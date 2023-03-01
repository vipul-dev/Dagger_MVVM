package com.dev.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.dev.daggermvvm.viewmodel.MainViewModel
import com.dev.daggermvvm.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val  products:TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this) {
            products.text = it.joinToString { x -> x.title + "\n\n" }
        }

    }
}