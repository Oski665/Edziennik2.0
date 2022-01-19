package com.example.edziennik20.ui.userdata

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class UserdataFragment  : Fragment() {


    var DB: Database? = null

    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreate(savedInstanceState)

        val binding =  inflater.inflate(R.layout.fragment_userdata,container,false)
        val textView1 = binding.findViewById(R.id.idListView) as TextView
        val textView2 = binding.findViewById(R.id.nameListView) as TextView
        val textView3 = binding.findViewById(R.id.lastNameListView) as TextView
        val textView4 = binding.findViewById(R.id.emailListView) as TextView
        DB = Database(this.context)
        val cursor = DB!!.getStudentData()

        cursor!!.moveToFirst();

        val data1 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_ID_UCZNIOWIE));
        val data2 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_NAME));
        val data3 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_LAST_NAME));
        val data4 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_EMAIL));

        textView1.setText(data1)
        textView2.setText(data2)
        textView3.setText(data3)
        textView4.setText(data4)


        return binding.rootView
    }
}


