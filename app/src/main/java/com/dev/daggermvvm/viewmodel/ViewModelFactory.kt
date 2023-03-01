package com.dev.daggermvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.daggermvvm.repository.ProductRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: ProductRepository) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository) as T

            else -> throw IllegalArgumentException("ViewModel class not found!")
        }
    }
}