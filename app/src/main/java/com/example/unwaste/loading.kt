package com.example.unwaste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent // For starting the main activity
import android.os.Handler // For delaying the transition to the main activity
import android.widget.ProgressBar
import android.widget.Button
import android.os.Looper



class loading : AppCompatActivity() {
    //private lateinit var progressBar: ProgressBar
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        // Initialize views
        //progressBar = findViewById(R.id.loadingProgressBar)
        startButton = findViewById(R.id.startButton)

        // Disable the button during loading
        startButton.isEnabled = false

        // Simulate a loading task with a delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Task completed, enable the button
            startButton.isEnabled = true
            // Handle button click to start the main activity
            startButton.setOnClickListener {
                // To test inventory activity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // To test maps activity
                //val intent = Intent(this, MapsActivity::class.java)
                //startActivity(intent)
                finish() // Close the loading activity
            }
        }, 2000) // Adjust the delay as needed
    }
}