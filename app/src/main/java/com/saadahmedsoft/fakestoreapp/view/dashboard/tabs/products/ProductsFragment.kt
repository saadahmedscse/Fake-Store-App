package com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products

import android.os.Bundle
import android.view.View
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.fakestoreapp.databinding.FragmentProductsBinding
import com.saadahmedsoft.fakestoreapp.services.model.product.ProductResponse
import com.saadahmedsoft.fakestoreapp.utils.ProgressDialog
import com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products.adapter.ProductAdapter
import com.saadahmedsoft.interfaces.OnItemActionListener
import com.saadahmedsoft.kotlinhelper.helper.observe
import com.saadahmedsoft.kotlinhelper.helper.setStaggeredGridLayoutManager
import com.saadahmedsoft.kotlinhelper.utils.DataState
import com.saadahmedsoft.kotlinhelper.utils.internetAvailable

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate), OnItemActionListener<ProductResponse> {
    override val title: String
        get() = "Fake Store Products"
    override val isBackButtonVisible: Boolean
        get() = false

    private val adapter by lazy {
        ProductAdapter(this)
    }

    private var productList: List<ProductResponse> = arrayListOf()

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.recyclerView.setStaggeredGridLayoutManager(2)
        binding.recyclerView.adapter = adapter

        if (requireContext().internetAvailable()) {
            appViewModel.getProducts("20")
        }
    }

    override fun observeData() {
        observe(appViewModel.products) {
            when (it) {
                is DataState.Loading -> {
                    ProgressDialog.show(requireContext())
                }
                is DataState.Success -> {
                    ProgressDialog.dismiss()
                    it.data?.let { items -> productList = items }
                    adapter.addItems(productList)
                }
                is DataState.Failed -> {
                    it.message?.let { err -> longSnackBar(err) }
                    ProgressDialog.dismiss()
                }
            }
        }
    }

    override fun onItemClickListener(view: View, item: ProductResponse, position: Int) {
        //
    }

    override fun onItemLongPressListener(view: View, item: ProductResponse, position: Int) {
        //
    }
}