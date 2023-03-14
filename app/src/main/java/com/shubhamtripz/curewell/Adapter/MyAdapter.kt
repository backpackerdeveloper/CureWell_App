package com.shubhamtripz.curewell.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shubhamtripz.curewell.Model.User
import com.shubhamtripz.curewell.R

class MyAdapter(private val userList: ArrayList<User>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val user :User = userList[position]
        holder.titleName.text = user.titleName
        holder.postName.text = user.postName
        holder.date.text = user.date
        holder.location.text = user.location
        holder.contact.text = user.contact

    }

    override fun getItemCount(): Int {

        return userList.size

    }

    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val titleName : TextView = itemView.findViewById(R.id.tvTitle)
        val postName : TextView = itemView.findViewById(R.id.tvpost)
        val date : TextView = itemView.findViewById(R.id.tvdate)
        val location : TextView = itemView.findViewById(R.id.tvlocation)
        val contact : TextView = itemView.findViewById(R.id.tvcontact)

    }



}