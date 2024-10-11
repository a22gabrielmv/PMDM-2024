package com.example.a1_9_secret

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val action = R.id.action_welcomeFragment_to_inputFragment
            requireView().findNavController().navigate(action)
        }

        return view
    }
}

