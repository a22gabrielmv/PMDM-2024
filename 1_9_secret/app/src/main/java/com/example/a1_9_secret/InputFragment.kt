package com.example.a1_9_secret

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class InputFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        val button = view.findViewById<Button>(R.id.button)
        val messageToEncrypt = view.findViewById<EditText>(R.id.textView)

        button.setOnClickListener {
            val message = messageToEncrypt.text.toString()

            val encryptedMessage = encryptMessage(message, 3)

            val action = InputFragmentDirections.actionInputFragmentToResultFragment(encryptedMessage)
            findNavController().navigate(action)
        }

        return view
    }

    val alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"

    fun encryptMessage(text: String, rotationKey: Int): String {
        var encryptedMessage = ""

        val message = text.uppercase()
        for (character in message) {
            val characterValue = alphabet.indexOf(character)

            val shiftCharacter = (characterValue + rotationKey) % alphabet.length

            encryptedMessage += alphabet[shiftCharacter]
        }

        return encryptedMessage
    }
}
