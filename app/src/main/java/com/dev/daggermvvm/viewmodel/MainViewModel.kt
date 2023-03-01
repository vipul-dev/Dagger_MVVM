package com.dev.daggermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.daggermvvm.models.Product
import com.dev.daggermvvm.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productLiveData: LiveData<List<Product>>
        get() = repository.product

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}