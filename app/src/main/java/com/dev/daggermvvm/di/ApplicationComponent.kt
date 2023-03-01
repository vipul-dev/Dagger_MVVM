package com.dev.daggermvvm.di

import com.dev.daggermvvm.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModules::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

}