package com.example.a1_10_cuento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class CuentoStart : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cuento_start, container, false)

        val button = view.findViewById<Button>(R.id.button)

        val nameBox = view.findViewById<EditText>(R.id.nombrePersona)

        button.setOnClickListener {
            val name = nameBox.text.toString()
            val action = CuentoStartDirections.actionCuentoStartToCuentoChoose(name)

            findNavController().navigate(action)
        }

        return view
    }
}