package com.learning.kotlin.retrofit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.learning.kotlin.retrofit.api.ApiHelper
import com.learning.kotlin.retrofit.model.Customer
import com.learning.kotlin.retrofit.model.OnCallBack
import com.learning.kotlin.retrofit.ui.CustomerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnCallBack {

    private lateinit var customerAdapter: CustomerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        customerRecyclerView.layoutManager = layoutManager
        customerAdapter = CustomerAdapter(arrayListOf())
        customerRecyclerView.adapter = customerAdapter
        ApiHelper.getAllCustomers(this)
    }

    override fun onSuccess(customers: ArrayList<Customer>) {
        progressBar.visibility = View.GONE
        customerAdapter.addCustomers(customers)
        customerRecyclerView.visibility = View.VISIBLE
    }

    override fun onfailure(message: String) {
        Toast.makeText(this, "Failure in fetching all the customers : $message",Toast.LENGTH_LONG).show()
    }

}