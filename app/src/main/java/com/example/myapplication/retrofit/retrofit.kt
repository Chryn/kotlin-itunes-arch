package com.example.myapplication.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

inline fun <reified T> initRetrofitClient(okHttpClient: OkHttpClient, endpoint: String): T {
    return Retrofit.Builder()
        .baseUrl(endpoint)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}

fun initOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.d("OkHttp", message)
        }
    })

    logging.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .addNetworkInterceptor(logging)
        .build()
}