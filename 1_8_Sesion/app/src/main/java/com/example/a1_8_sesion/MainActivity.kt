package com.example.a1_8_sesion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var user = findViewById<EditText>(R.id.user)
        var pass = findViewById<EditText>(R.id.pass)
        var res = findViewById<EditText>(R.id.result)
        var sesion = findViewById<Button>(R.id.button)
        val errorMessage: String = getString(R.string.error)
        val userText: String = getString(R.string.userText)
        val passText: String = getString(R.string.passText)


        sesion.setOnClickListener{
            if (user.text.toString()=="" || pass.text.toString()==""){
                res.setText(errorMessage)
            }
            else{
                res.setText(userText + user.text + " " + passText + pass.text)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}