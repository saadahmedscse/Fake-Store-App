package com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products

import android.os.Bundle
import android.util.Log
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.fakestoreapp.databinding.FragmentProductsBinding
import com.saadahmedsoft.fakestoreapp.utils.ProgressDialog
import com.saadahmedsoft.kotlinhelper.helper.observe
import com.saadahmedsoft.kotlinhelper.utils.DataState

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {
    override val title: String
        get() = "Fake Store Products"
    override val isBackButtonVisible: Boolean
        get() = false

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        appViewModel.getProducts("5")
    }

    override fun observeData() {
        observe(appViewModel.products) {
            when (it) {
                is DataState.Loading -> {
                    ProgressDialog.show(requireContext())
                }
                is DataState.Success -> {
                    Log.d("observable_debug", it.data?.get(0)?.title!!)
                    ProgressDialog.dismiss()
                }
                is DataState.Failed -> {
                    it.message?.let { err -> longSnackBar(err) }
                    ProgressDialog.dismiss()
                }
            }
        }
    }
}