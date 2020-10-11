package com.learning.kotlin.retrofit.api

import com.learning.kotlin.retrofit.model.Customer
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("allCustomers")
    fun getAllCustomers(): Call<ArrayList<Customer>>

}