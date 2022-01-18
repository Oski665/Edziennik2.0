package com.example.edziennik20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.edziennik20.ui.database.Database
import kotlin.properties.Delegates
import android.R.layout.activity_list_item
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.view.View


class MainActivity : AppCompatActivity() {
    var email: EditText? = null
    var password: EditText? = null
    var btn_click_me: Button? = null
    var DB: Database? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        val password = findViewById(R.id.editTextPass) as EditText
        val email = findViewById(R.id.editTextEmail) as EditText
        val btn_click_me = findViewById(R.id.btn_click_me) as Button


DB = Database(this)

        btn_click_me!!.setOnClickListener(object : View.OnClickListener {
    override fun onClick(view: View?) {
        val user = email!!.text.toString()
        val pass = password!!.text.toString()
        if (user == "" || pass == "") Toast.makeText(
            this@MainActivity,
            "Uzupełnij wszystkie pola",
            Toast.LENGTH_SHORT
        ).show() else {
            val checkuserpass: Boolean = DB!!.checkusernamepassword(user, pass)
            if (checkuserpass == true) {
                Toast.makeText(
                    this@MainActivity,
                    "Zalogowano!",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(applicationContext, MainActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Złe dane",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
})
}
}
