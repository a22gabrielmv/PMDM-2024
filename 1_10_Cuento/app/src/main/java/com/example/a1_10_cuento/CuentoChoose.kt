package com.example.a1_10_cuento

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class CuentoChoose : Fragment() {

    private val args: CuentoChooseArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.cuento_choose, container, false)

        val cardBosque = view.findViewById<CardView>(R.id.cardB)
        val cardCasa = view.findViewById<CardView>(R.id.cardC)

        cardBosque.setOnClickListener {
            val action = CuentoChooseDirections.actionCuentoChooseToCuentoBosque(args.name)
            findNavController().navigate(action)
        }

        cardCasa.setOnClickListener {
            val action = CuentoChooseDirections.actionCuentoChooseToCuentoCasa(args.name)
            findNavController().navigate(action)
        }

        return view
    }
}