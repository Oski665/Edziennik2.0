package com.example.edziennik20.ui.grades

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database


class GradesFragment  : Fragment() {

    var DB: Database? = null
    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val binding =  inflater.inflate(R.layout.grades_layout,container,false)
        val mat = binding.findViewById(R.id.item_matematyka) as TextView
        val pol = binding.findViewById(R.id.item_polski) as TextView
        val ang = binding.findViewById(R.id.item_angielski) as TextView
        val biol = binding.findViewById(R.id.item_biologia) as TextView
        val fiz = binding.findViewById(R.id.item_fizyka) as TextView
        val poloceny = binding.findViewById(R.id.item_polGrades) as TextView
        val angoceny = binding.findViewById(R.id.item_angGrades) as TextView
        val bioloceny = binding.findViewById(R.id.item_bioGrades) as TextView
        val fizoceny = binding.findViewById(R.id.item_fizGrades) as TextView
        val matoceny = binding.findViewById(R.id.item_matGrades) as TextView
        DB = Database(this.context)
        val cursor1 = DB!!.getOcenyMat()
        val cursor2 = DB!!.getOcenyJpol()
        val cursor3 = DB!!.getOcenyJang()
        val cursor4 = DB!!.getOcenyBio()
        val cursor5 = DB!!.getOcenyFiz()


        cursor1!!.moveToFirst();
        cursor2!!.moveToFirst();
        cursor3!!.moveToFirst();
        cursor4!!.moveToFirst();
        cursor5!!.moveToFirst();

        val data1 = cursor1!!.getString(cursor1.getColumnIndex(Database.COLUMN_NAZWA_PRZEDMIOTU));
        val data2 = cursor2!!.getString(cursor1.getColumnIndex(Database.COLUMN_NAZWA_PRZEDMIOTU));
        val data3 = cursor3!!.getString(cursor1.getColumnIndex(Database.COLUMN_NAZWA_PRZEDMIOTU));
        val data4 = cursor4!!.getString(cursor1.getColumnIndex(Database.COLUMN_NAZWA_PRZEDMIOTU));
        val data5 = cursor5!!.getString(cursor1.getColumnIndex(Database.COLUMN_NAZWA_PRZEDMIOTU));

        cursor1!!.moveToFirst();
        cursor2!!.moveToFirst();
        cursor3!!.moveToFirst();
        cursor4!!.moveToFirst();
        cursor5!!.moveToFirst();

        val data6 = cursor1!!.getString(cursor1.getColumnIndex(Database.COLUMN_OCENA));
        val data7 = cursor2!!.getString(cursor1.getColumnIndex(Database.COLUMN_OCENA));
        val data8 = cursor3!!.getString(cursor1.getColumnIndex(Database.COLUMN_OCENA));
        val data9 = cursor4!!.getString(cursor1.getColumnIndex(Database.COLUMN_OCENA));
        val data10 = cursor5!!.getString(cursor1.getColumnIndex(Database.COLUMN_OCENA));

        mat.setText(data1)
        pol.setText(data2)
        ang.setText(data3)
        biol.setText(data4)
        fiz.setText(data5)
        matoceny.setText(data6)
        poloceny.setText(data7)
        angoceny.setText(data8)
        bioloceny.setText(data9)
        fizoceny.setText(data10)


        return binding.rootView
    }
}