package com.devanshu.physicswallahassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.lang.StringBuilder

class MyAdapter(private val context: Context, private val userList: List<MyDataItem>?):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var username: TextView = itemView.findViewById(R.id.txtName)
        var subject: TextView = itemView.findViewById(R.id.txtSubject)
        var qualification: TextView = itemView.findViewById(R.id.txtQualification)
        var image : ImageView = itemView.findViewById(R.id.imgProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemview = LayoutInflater.from(context).inflate(R.layout.row_items,parent,false)

        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //for cache of image
        val requestOptions = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
        // for string append
        val myStringBuilder = StringBuilder()

        holder.username.text = userList!![position].name
        for (item in userList[position].subjects.indices){
            holder.subject.text = userList[position].subjects[item]
        }
        for (item in userList[position].qualification.indices){
            holder.qualification.text = myStringBuilder.append(userList[position].qualification[item])
            myStringBuilder.append("\n")

        }

        //loading image using glide
        Glide.with(context).load(userList[position].profileImage).apply(requestOptions).into(holder.image)

    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

}