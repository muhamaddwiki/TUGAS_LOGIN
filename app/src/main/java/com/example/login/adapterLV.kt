package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.model.ResultLogin

class adapterLV(private val listuser: ArrayList<ResultLogin>) : RecyclerView.Adapter<adapterLV.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_user, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user= listuser[position]

        holder.textuser.text=user.username
        holder.textrole.text = user.role


        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listuser[holder.adapterPosition]) }
    }



    override fun getItemCount(): Int {
        return listuser.size
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textuser: TextView = itemView.findViewById(R.id.textuser)
        var textrole: TextView = itemView.findViewById(R.id.textrole)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data:ResultLogin)
    }
}