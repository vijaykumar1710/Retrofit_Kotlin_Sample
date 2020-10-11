package com.learning.kotlin.retrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.learning.kotlin.retrofit.R
import com.learning.kotlin.retrofit.model.Customer
import kotlinx.android.synthetic.main.customer_view_layout.view.*

class CustomerAdapter(private val customers: ArrayList<Customer>?) : RecyclerView.Adapter<CustomerAdapter.DataViewHolder>(){

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(customer : Customer) {
            itemView.apply {
                customerName.text = customer.customerName
                customerMobile.text = customer.customerMobile.toString()
                customerEmail.text = customer.customerEmail
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customer_view_layout,parent,false))


    override fun getItemCount() : Int = customers!!.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(customers!![position] )
    }

    fun addCustomers(customer : List<Customer>) {
        customers!!.clear()
        customers!!.addAll(customer)
        notifyDataSetChanged()
    }

}
