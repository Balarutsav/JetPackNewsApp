package com.example.jetpackdemo.di

import com.example.jetpackdemo.BuildConfig
import com.example.jetpackdemo.data.DemoAPi
import com.example.jetpackdemo.data.remote.BaseDataSource
import com.example.jetpackdemo.util.Constants.Companion.BASE_URL

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient())

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
    fun okHttpClient(): OkHttpClient {
        val levelType: HttpLoggingInterceptor.Level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()

        httpClient.addInterceptor(Interceptor { chain ->
            val original: Request = chain.request()
            val requestBuilder = original.newBuilder()
                .header("Accept-Encoding", "gzip, deflate, br")
                .build();

            chain.proceed(requestBuilder)
        })


        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.addNetworkInterceptor(logging)
        val client = httpClient.build()
        return client
    }

    @Singleton
    @Provides
    fun provideGameApi(retrofit: Retrofit): DemoAPi {
        return retrofit.create(DemoAPi::class.java)
    }

}