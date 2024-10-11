package com.example.a1_10_cuento

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class CuentoCasa : Fragment() {

    private val args: CuentoCasaArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cuento_casa, container, false)

        val button = view.findViewById<Button>(R.id.returnHome)

        val text = view.findViewById<TextView>(R.id.contenido)

        val oldText=text.text.toString()

        if (args.name==""){
            text.text= "Usuario: " + oldText
        }
        else{
            text.text= args.name + ": " + oldText
        }
        button.setOnClickListener {
            val action = R.id.action_cuentoCasa_to_cuentoStart
            findNavController().navigate(action)
        }

        return view
    }
}