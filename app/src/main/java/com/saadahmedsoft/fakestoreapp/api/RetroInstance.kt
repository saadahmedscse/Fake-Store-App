package com.saadahmedsoft.fakestoreapp.api

import com.google.gson.GsonBuilder
import com.saadahmedsoft.base.utils.Constants.Api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroInstance {
    private val gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val instance: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}