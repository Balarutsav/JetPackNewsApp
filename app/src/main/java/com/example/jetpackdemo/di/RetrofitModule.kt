package com.example.jetpackdemo.di

import com.example.jetpackdemo.data.DemoAPi
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.util.Constants.Companion.BASE_URL

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideBaseDataSource() : BaseDataSource {
        return BaseDataSource()

    }


    @Singleton
    @Provides
    fun provideGameApi(retrofit: Retrofit): DemoAPi {
        return retrofit.create(DemoAPi::class.java)
    }

}