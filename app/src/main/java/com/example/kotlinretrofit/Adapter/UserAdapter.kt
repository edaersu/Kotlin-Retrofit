package com.example.kotlinretrofit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinretrofit.Model.User
import com.example.kotlinretrofit.R

class UserAdapter(val userlist: MutableList<User>) :
    RecyclerView.Adapter<UserAdapter.ModelViewHolder>() {
    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val id: TextView = view.findViewById(R.id.id)
        val name: TextView = view.findViewById(R.id.name)
        val username: TextView = view.findViewById(R.id.username)
        val email: TextView = view.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {

        val dataModel = userlist[position]
        holder.id.setText(dataModel.id)
        holder.name.setText(dataModel.name)
        holder.username.setText(dataModel.username)
        holder.email.setText(dataModel.email_user)


    }
}