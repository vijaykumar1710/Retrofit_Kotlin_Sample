package com.learning.kotlin.retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder{

    private val BASE_URL = "https://5f8189215b1f3f00161a6adb.mockapi.io/customers/";

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}