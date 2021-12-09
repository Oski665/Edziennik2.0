package com.example.edziennik20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click_me = findViewById(R.id.btn_click_me) as Button

        btn_click_me.setOnClickListener{
            val intent = Intent(this,MainActivity2::class.java)
            Toast.makeText(this@MainActivity, "Zalogowano", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

//        val listView = findViewById(R.id.listView) as ListView
//        val butons = arrayOf()

    }


}