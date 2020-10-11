package com.learning.kotlin.retrofit.api

import com.learning.kotlin.retrofit.model.Customer
import com.learning.kotlin.retrofit.model.OnCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ApiHelper{

     var customer: ArrayList<Customer>? = null

     fun getAllCustomers(onCallBack: OnCallBack): ArrayList<Customer>? {

          val apiInterface = RetrofitBuilder.getRetrofit().create(ApiInterface::class.java)
          val call = apiInterface.getAllCustomers()
          call.enqueue(object : Callback<ArrayList<Customer>> {

               /**
                * Invoked for a received HTTP response.
                *
                *
                * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                * Call [Response.isSuccessful] to determine if the response indicates success.
                */
               override fun onResponse(
                    call: Call<ArrayList<Customer>>,
                    response: Response<ArrayList<Customer>>
               ) {
                    customer = (response.body() as ArrayList<Customer>?)!!
                    onCallBack.onSuccess(customer!!)
               }

               /**
                * Invoked when a network exception occurred talking to the server or when an unexpected exception
                * occurred creating the request or processing the response.
                */
               override fun onFailure(call: Call<ArrayList<Customer>>, t: Throwable) {
                    customer = null
                    onCallBack.onfailure(t.localizedMessage)
               }

          })

          return customer
     }

}
