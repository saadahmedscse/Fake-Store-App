package com.saadahmedsoft.fakestoreapp.api

import com.saadahmedsoft.fakestoreapp.services.model.product.ProductResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("products")
    fun getProducts(@Query("limit") limit: String): Observable<List<ProductResponse>>
}