package com.example.edziennik20.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class CommentsAdapter: RecyclerView.Adapter<CommentsAdapter.ViewHolder>(){




    private var titles = arrayOf("Uwaga 1","Uwaga 2","Uwaga 3","Uwaga 4","Uwaga 5","Uwaga 6","Uwaga 7")
    private var descriptions = arrayOf("Opis 1","Opis 2","Opis 3","Opis 4","Opis 5","Opis 6","Opis 7")
//    private var images = intArrayOf(R.drawable.attention,R.drawable.attention,R.drawable.attention,R.drawable.attention,R.drawable.attention,R.drawable.attention,R.drawable.attention)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CommentsAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDescription.text = descriptions[position]
//        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        var itemImage: ImageView
        var itemTitle: TextView
        var itemDescription: TextView

        init{
//            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDescription = itemView.findViewById(R.id.item_description)
        }
    }
}