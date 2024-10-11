package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val EUR="eur"
    val DOLLAR2="dolar2"


    private var valor: Double = 0.0
    private var valor2: Double = 0.0

    private var cadena: String = ""
    private var cadena2: String = ""


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble(EUR, valor)
        outState.putDouble(DOLLAR2, valor2)


        super.onSaveInstanceState(outState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val buttonConvert2 = findViewById<Button>(R.id.buttonConvert2)

        val eurValue = findViewById<EditText>(R.id.euro)
        val dollarValue = findViewById<EditText>(R.id.dolar)

        val eurValue2 = findViewById<EditText>(R.id.euro2)
        val dollarValue2 = findViewById<EditText>(R.id.dolar2)

        if (savedInstanceState!=null){
            eurValue.setText("" + savedInstanceState.getDouble(EUR))

            eurValue2.setText("" + savedInstanceState.getDouble(DOLLAR2))

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonConvert.setOnClickListener{
            cadena = eurValue.getText().toString()
            valor = cadena.toDouble()*1.12
            dollarValue.setText(""+String.format("%.2f", valor))
        }

        buttonConvert2.setOnClickListener{
            cadena2 = dollarValue2.getText().toString()
            valor2 = cadena2.toDouble()/1.12
            eurValue2.setText(""+String.format("%.2f", valor2))
        }
    }
}