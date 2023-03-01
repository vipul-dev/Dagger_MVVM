package com.dev.daggermvvm.retrofit

import com.dev.daggermvvm.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProducts():Response<List<Product>>

}