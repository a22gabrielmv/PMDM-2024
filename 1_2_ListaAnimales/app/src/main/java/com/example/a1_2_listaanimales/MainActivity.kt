package com.example.a1_2_listaanimales

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        val btnSend= findViewById<Button>(R.id.buttonSend)

        btnSend.setOnClickListener{
            val spinnerAnimal =findViewById<Spinner>(R.id.animal_list)
            val textAnimal =findViewById<TextView>(R.id.textAnimal)
            textAnimal.text= "Pillaste: ${spinnerAnimal.selectedItem}"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}