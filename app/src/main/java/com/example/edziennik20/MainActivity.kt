package com.example.edziennik20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.edziennik20.ui.database.Database
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    lateinit var database : Database;
    lateinit var Email: String
    lateinit var Password: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val password = findViewById<EditText>(R.id.editTextPass)
        val email = findViewById<EditText>(R.id.editTextEmail)
        val btn_click_me = findViewById(R.id.btn_click_me) as Button


        database = Database(this);

        btn_click_me.setOnClickListener{


            Email =  email.text.toString();
            Password =  password.text.toString();


            if(Email.equals("")||Password.equals("")){
                Toast.makeText(this@MainActivity,"Uzupełnij wszystkie pola",Toast.LENGTH_SHORT)
            } else {
                var checkuserpass : Boolean = database.checkusernamepassword(Email, Password);
                if(checkuserpass==true){
                    val intent = Intent(this,MainActivity2::class.java)
                    Toast.makeText(this@MainActivity, "Zalogowano", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                } else {
                    Toast.makeText(this@MainActivity, "Niepoprawne dane", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                }
            }
//            val intent = Intent(this,MainActivity2::class.java)
//            Toast.makeText(this@MainActivity, "Zalogowano", Toast.LENGTH_SHORT).show()
//            startActivity(intent)
        }

    }

}