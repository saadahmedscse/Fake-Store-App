package com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
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
    private var limit = 10
    private var previousListSize = 0 //Added this for checking is more data available after pagination or not
    private var moreDataAvailable = true

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        binding.recyclerView.setStaggeredGridLayoutManager(2)
        binding.recyclerView.adapter = adapter

        if (requireContext().internetAvailable()) {
            appViewModel.getProducts(limit.toString())
        }

        paginate()

        binding.etSearchBox.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                filterItem(s.toString().lowercase())
            }
        })
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

                    if (previousListSize == productList.size) {
                        shortSnackBar("No more item found")
                        moreDataAvailable = false
                    }
                    else previousListSize = productList.size

                    adapter.addItems(productList)
                }
                is DataState.Failed -> {
                    it.message?.let { err -> longSnackBar(if (err == "timeout") "Request Timeout" else err) }
                    ProgressDialog.dismiss()
                }
            }
        }
    }

    private fun paginate() {
        binding.recyclerView.addOnScrollListener(object : OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (!recyclerView.canScrollVertically(1) && moreDataAvailable) {
                    limit *= 2
                    appViewModel.getProducts(limit.toString())
                }
            }
        })
    }

    private fun filterItem(txt: String) {
        val fList = arrayListOf<ProductResponse>()

        for (item in productList) {
            if (item.title?.lowercase()?.contains(txt)!!) fList.add(item)
        }

        adapter.addItems(fList)
    }

    override fun onItemClickListener(view: View, item: ProductResponse, position: Int) {
        //
    }

    override fun onItemLongPressListener(view: View, item: ProductResponse, position: Int) {
        //
    }
}