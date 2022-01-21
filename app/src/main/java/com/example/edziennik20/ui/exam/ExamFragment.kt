package com.example.edziennik20.ui.exam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class ExamFragment  : Fragment() {
    var DB: Database? = null
    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        DB = Database(this.context)
        val binding =  inflater.inflate(R.layout.fragment_exam,container,false)

        val textView1 = binding.findViewById(R.id.testListView) as TextView
        val textView2 = binding.findViewById(R.id.idtestuListView) as TextView
        val cursor = DB!!.getTest()

        //cursor!!.moveToFirst();
        while(cursor!!.moveToNext()) {
            // val data1 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_TRESC));


            textView1.append(cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_DATA)))

            textView2.append(cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_ID_TEST)))

        }

        return binding.rootView
    }

}
