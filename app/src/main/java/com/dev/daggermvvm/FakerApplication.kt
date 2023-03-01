package com.dev.daggermvvm

import android.app.Application
import com.dev.daggermvvm.di.ApplicationComponent
import com.dev.daggermvvm.di.DaggerApplicationComponent

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()

    }

}