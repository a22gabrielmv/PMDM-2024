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
        val btnSend = findViewById<Button>(R.id.buttonSend)
        val spinnerAnimal = findViewById<Spinner>(R.id.animal_list)
        val textAnimal = findViewById<TextView>(R.id.textAnimal)

        btnSend.setOnClickListener {
            val selectedAnimal = spinnerAnimal.selectedItem.toString()
            val typesArrayId = when (selectedAnimal) {
                "Dog" -> R.array.typesDog
                "Cat" -> R.array.typesCat
                "Bird" -> R.array.typesBird
                else -> 0
            }

            if (typesArrayId != 0) {
                val typesArray = resources.getStringArray(typesArrayId)
                textAnimal.text = "Types of $selectedAnimal: ${typesArray.joinToString(", ")}"
            } else {
                textAnimal.text = "No types found for $selectedAnimal"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
