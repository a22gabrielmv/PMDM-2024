package com.example.a1_10_cuento

import ChatResponse
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

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CuentoCasa : Fragment() {


    private val args: CuentoCasaArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.cuento_casa, container, false)
        val textView = view.findViewById<TextView>(R.id.contenido)
        val button = view.findViewById<Button>(R.id.returnHome)

        fetchStory("casa encantada", textView)

        button.setOnClickListener {
            val action = R.id.action_cuentoCasa_to_cuentoStart
            findNavController().navigate(action)
        }

        return view
    }

    private fun fetchStory(theme: String, textView: TextView) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openai.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(OpenAIApi::class.java)

        val name=args.name

        val request = ChatRequest(
            model = "gpt-3.5-turbo",
            messages = listOf(ChatRequest.Message("user", "Escribe un cuento de 50 palabras sobre un/una $theme. Que el protagonista tenga el nombre de "+ name))
        )

        api.getChatResponse(request).enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val story = response.body()?.choices?.firstOrNull()?.message?.content
                    textView.text = story ?: "No se pudo obtener el cuento."
                } else {
                    val errorBody = response.errorBody()?.string()
                    textView.text = "Error en la respuesta de la API: ${response.code()} - $errorBody"
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                textView.text = "Error de red: ${t.message}"
            }
        })
    }
}