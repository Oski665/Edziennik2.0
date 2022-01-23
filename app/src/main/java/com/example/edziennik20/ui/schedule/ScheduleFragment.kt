package com.example.edziennik20.ui.schedule

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class ScheduleFragment  : Fragment() {
    var DB: Database? = null
    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val binding =  inflater.inflate(R.layout.fragment_schedule,container,false)
        val monday = binding.findViewById(R.id.item_subjects1) as TextView
        val tuesday = binding.findViewById(R.id.item_subjects2) as TextView
        val wednesday = binding.findViewById(R.id.item_subjects3) as TextView
        val thursday = binding.findViewById(R.id.item_subjects4) as TextView
        val friday = binding.findViewById(R.id.item_subjects5) as TextView
        DB = Database(this.context)
        val cursor1 = DB!!.getPon()
        val cursor2 = DB!!.getWto()
        val cursor3 = DB!!.getSro()
        val cursor4 = DB!!.getCzw()
        val cursor5 = DB!!.getPia()


        cursor1!!.moveToFirst();
        cursor2!!.moveToFirst();
        cursor3!!.moveToFirst();
        cursor4!!.moveToFirst();
        cursor5!!.moveToFirst();

        val data1 = cursor1!!.getString(cursor1.getColumnIndex(Database.COLUMN_PRZEDMIOTY));
        val data2 = cursor2!!.getString(cursor2.getColumnIndex(Database.COLUMN_PRZEDMIOTY));
        val data3 = cursor3!!.getString(cursor3.getColumnIndex(Database.COLUMN_PRZEDMIOTY));
        val data4 = cursor4!!.getString(cursor4.getColumnIndex(Database.COLUMN_PRZEDMIOTY));
        val data5 = cursor5!!.getString(cursor5.getColumnIndex(Database.COLUMN_PRZEDMIOTY));

        monday.setText(data1)
        tuesday.setText(data2)
        wednesday.setText(data3)
        thursday.setText(data4)
        friday.setText(data5)


        return binding.rootView
    }
}