package com.example.myapplication_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Country_Adapter(private val countryList : ArrayList<Country>) : RecyclerView.Adapter<Country_Adapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = countryList[position]
        holder.tvHeading.text = currentItem.country
        var prefix = currentItem.country.substring(0,1)

        holder.tvPrefix.text = prefix;

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tvHeading = itemView.findViewById<TextView>(R.id.tvCountryname)
        var tvPrefix = itemView.findViewById<TextView>(R.id.tvPrefix)

    }



}