package com.example.a1_7_ciudad

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var ourense = findViewById<ImageView>(R.id.imageView2)
        var santiago = findViewById<ImageView>(R.id.imageView)
        var text = findViewById<TextView>(R.id.textView4)

        mediaPlayer = MediaPlayer.create(this, R.raw.sound)


        ourense.setOnClickListener{
            mediaPlayer.start()
            text.setText("Ourense cosas fribueres jngroibsgbuis ibuiboe rrbydrbyuguisdguibgsuiegius")
        }

        santiago.setOnClickListener{
            mediaPlayer.start()
            text.setText("Santiago cosas ierjbwgv iohfsogfebsnafugbywa ygdyersbbfkjbdjkvdusiufsiu s732643283427")
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        if (this::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}