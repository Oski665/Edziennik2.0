package com.example.edziennik20.ui.userdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edziennik20.R
import com.example.edziennik20.ui.database.Database

class UserdataFragment  : Fragment() {
    var DB: Database? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreate(savedInstanceState)

        val binding =  inflater.inflate(R.layout.fragment_userdata,container,false)
        val textView = binding.findViewById(R.id.editTextPass) as TextView

//        DB = Database(this)

        textView.setText("Co jest grane")
        return binding.rootView
    }
}