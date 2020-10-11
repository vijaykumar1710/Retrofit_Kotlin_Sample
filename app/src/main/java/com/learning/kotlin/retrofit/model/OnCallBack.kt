package com.learning.kotlin.retrofit.model

interface OnCallBack {
    fun onSuccess(customers : ArrayList<Customer>)
    fun onfailure(message : String)
}