package com.example.edziennik20.ui.extraactivities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class ExtraActivitiesFragment  : Fragment() {

    var DB: Database? = null
    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DB = Database(this.context)
        val binding =  inflater.inflate(R.layout.fragment_extraactivities,container,false)

        val textView1 = binding.findViewById(R.id.activitiesListView) as TextView
        val textView2 = binding.findViewById(R.id.item_description2) as TextView

        val cursor = DB!!.getDodA()


        while(cursor!!.moveToNext()) {
            // val data1 = cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_TRESC));


            textView1.append(cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_TRESC_DODA)))
            textView1.append("\n")
            textView1.append("\n")
            textView2.append(cursor!!.getString(cursor.getColumnIndex(Database.COLUMN_ID_DODA)))
            textView1.append("\n")
            textView1.append("\n")
        }

        return binding.rootView
    }
}