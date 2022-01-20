package com.example.edziennik20.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.CommentData

class CommentsAdapter(private val context : Activity,private val arrayList : ArrayList<CommentData>) : ArrayAdapter<CommentData>(context,
    R.layout.list_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item,null)

        val cmt : TextView = view.findViewById(R.id.commentText)
        val desc : TextView = view.findViewById(R.id.descriptionText)
        val cmtTime : TextView = view.findViewById(R.id.commentTime)

        cmt.text = arrayList[position].commentText
        desc.text = arrayList[position].decriptionText
        cmtTime.text = arrayList[position].commentTime

        return view
    }
}