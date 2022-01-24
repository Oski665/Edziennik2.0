package com.example.edziennik20.ui.comments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class CommentsFragment  : Fragment() {


    var DB: Database? = null
    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        DB = Database(this.context)
        val binding =  inflater.inflate(R.layout.fragment_comments,container,false)

        val textView1 = binding.findViewById(R.id.item_title) as TextView
        val textView2 = binding.findViewById(R.id.item_description) as TextView

//        val commentText = arrayOf("Uwaga 1","Uwaga 2","Uwaga 3","Uwaga 4","Uwaga 5","Uwaga 6","Uwaga 7")
//
//        val description = arrayOf("Opis 1", "Opis 2", "Opis 3", "Opis 4", "Opis 5", "Opis 6", "Opis 7",)
//
//        val commentTime = arrayOf(" 7:00 pm"," 8:00 pm"," 9:00 pm"," 10:00 pm"," 11:00 pm"," 6:00 am"," 5:00 am")

        // commentArrayList = ArrayList()

//        for(i in commentText.indices){
//           val  comment = CommentData(commentText[i], description[i], commentTime[i])
//            commentArrayList.add(comment)
//        }
//        for (commentText in commentArrayList) {
//            textView1.append(commentText.toString())
//            textView1.append("\n");
//        }

        val cursor = DB!!.getUwaga()

        //cursor!!.moveToFirst();
        while(cursor!!.moveToNext()) {
            // val data1 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_TRESC));


            textView1.append(cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_TRESC)))
            textView1.append("\n")
            textView1.append("\n")
            textView2.append(cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_ID_UWAGI)))
            textView2.append("\n")
            textView2.append("\n")

        }

        return binding.rootView
    }


}