package com.dev.daggermvvm.di

import com.dev.daggermvvm.retrofit.FakerApi
import com.dev.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModules {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideFakerApi(retrofit: Retrofit): FakerApi {
        return retrofit.create(FakerApi::class.java)
    }
}