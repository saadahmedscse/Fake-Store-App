package com.saadahmedsoft.fakestoreapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saadahmedsoft.fakestoreapp.services.model.product.ProductResponse
import com.saadahmedsoft.fakestoreapp.services.repository.AppRepo
import com.saadahmedsoft.kotlinhelper.utils.DataState

class AppViewModel : ViewModel() {
    private val repo = AppRepo()

    private val _products = MutableLiveData<DataState<List<ProductResponse>>>()
    val products: LiveData<DataState<List<ProductResponse>>>
        get() = _products

    fun getProducts(limit: String) {
        repo.getProducts(limit, _products)
    }
}