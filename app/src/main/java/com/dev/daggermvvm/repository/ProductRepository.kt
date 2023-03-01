package com.dev.daggermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.daggermvvm.models.Product
import com.dev.daggermvvm.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi) {

    private val _products = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = fakerApi.getProducts()
        if (result.isSuccessful && result.body() != null) {
            _products.value = result.body()
        }
    }

}