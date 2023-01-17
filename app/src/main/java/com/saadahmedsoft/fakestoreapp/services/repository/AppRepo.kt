package com.saadahmedsoft.fakestoreapp.services.repository

import androidx.lifecycle.MutableLiveData
import com.saadahmedsoft.fakestoreapp.api.RetroInstance
import com.saadahmedsoft.fakestoreapp.services.model.product.ProductResponse
import com.saadahmedsoft.fakestoreapp.utils.ObserverUtil
import com.saadahmedsoft.kotlinhelper.utils.DataState

class AppRepo {

    private val instance = RetroInstance.instance

    fun getProducts(limit: String, mutableLiveData: MutableLiveData<DataState<List<ProductResponse>>>) {
        ObserverUtil.observe(instance.getProducts(limit), mutableLiveData)
    }
}