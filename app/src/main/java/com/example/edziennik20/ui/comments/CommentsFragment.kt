package com.example.edziennik20.ui.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.databinding.ActivityMainBinding
import com.example.edziennik20.ui.database.CommentData

class CommentsFragment  : Fragment() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var commentArrayList : ArrayList<CommentData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val commentText = arrayOf("Uwaga 1","Uwaga 2","Uwaga 3","Uwaga 4","Uwaga 5","Uwaga 6","Uwaga 7")

        val description = arrayOf("Opis 1", "Opis 2", "Opis 3", "Opis 4", "Opis 5", "Opis 6", "Opis 7",)

        val commentTime = arrayOf(" 7:00 pm"," 8:00 pm"," 9:00 pm"," 10:00 pm"," 11:00 pm"," 6:00 am"," 5:00 am")

        commentArrayList = ArrayList()

        for(i in commentText.indices){
            val comment = CommentData(commentText[i], description[i], commentTime[i])
            commentArrayList.add(comment)
        }


        return inflater.inflate(R.layout.fragment_comments,container,false)
    }


}