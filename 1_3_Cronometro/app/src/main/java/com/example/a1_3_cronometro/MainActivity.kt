package com.example.a1_3_cronometro

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val RUNNING_KEY="running"
    val OFFSET_KEY="offset"
    val BASE_KEY="base"

    private lateinit var chronometer: Chronometer
    private var pauseOffset: Long = 0
    private var isRunning: Boolean = false

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, isRunning)
        outState.putLong(OFFSET_KEY, pauseOffset)
        outState.putLong(BASE_KEY, chronometer.base)

        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        chronometer = findViewById(R.id.crono)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonPause = findViewById<Button>(R.id.buttonPause)
        val buttonRestart = findViewById<Button>(R.id.buttonRestart)

        if (savedInstanceState!=null){
            pauseOffset=savedInstanceState.getLong(OFFSET_KEY)
            isRunning=savedInstanceState.getBoolean(RUNNING_KEY)

            if (isRunning){
                chronometer.base=savedInstanceState.getLong(BASE_KEY)
                chronometer.start()
            }
            else{
                chronometer.base=SystemClock.elapsedRealtime() - pauseOffset
            }
        }

        // Start
        buttonStart.setOnClickListener {
            if (!isRunning) {
                chronometer.base = SystemClock.elapsedRealtime() - pauseOffset
                chronometer.start()
                isRunning = true
            }
        }

        // Pause
        buttonPause.setOnClickListener {
            if (isRunning) {
                chronometer.stop()
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.base
                isRunning = false
            }
        }

        // Restart
        buttonRestart.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            pauseOffset = 0
            // chronometer.start()
            // isRunning = true
            chronometer.stop()
            isRunning = false
        }
    }
}
