package com.flexcode.roomdatabase.Fragments.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexcode.roomdatabase.R
import com.flexcode.roomdatabase.data.User
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    //return userList size
    override fun getItemCount(): Int {
        return userList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.tvId.text = currentItem.id.toString()
        holder.itemView.tvFirstName.text = currentItem.FirstName
        holder.itemView.tvLastName.text = currentItem.lastName
        holder.itemView.tvAge.text = currentItem.age.toString()
    }
    fun setData(User: List<User>){
        this.userList = User
        notifyDataSetChanged()
    }


}