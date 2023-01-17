package com.saadahmedsoft.fakestoreapp.view.dashboard.tabs.products

import android.os.Bundle
import com.saadahmedsoft.base.BaseFragment
import com.saadahmedsoft.fakestoreapp.databinding.FragmentProductsBinding

class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {
    override val title: String
        get() = "Home"
    override val isBackButtonVisible: Boolean
        get() = false

    override fun onFragmentCreate(savedInstanceState: Bundle?) {
        //
    }

    override fun observeData() {
        //
    }
}