package com.example.a1_9_secret

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ResultFragment : Fragment() {

    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        val button = view.findViewById<Button>(R.id.button)
        val messageGoesHere = view.findViewById<TextView>(R.id.editTextFinal)

        messageGoesHere.text = args.encryptedMessage

        button.setOnClickListener {
            val action = R.id.action_resultFragment_to_welcomeFragment
            findNavController().navigate(action)
        }

        return view
    }
}
