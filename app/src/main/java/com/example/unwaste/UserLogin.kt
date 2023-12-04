package com.example.unwaste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button

class UserLogin : AppCompatActivity() {
    private lateinit var startButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        // Additional logic for your UserLogin activity

        // Initialize views
        //progressBar = findViewById(R.id.loadingProgressBar)
        startButton = findViewById(R.id.button)

        // Disable the button during loading
        startButton.isEnabled = false

        // Simulate a loading task with a delay
        Handler(Looper.getMainLooper()).postDelayed({
            // Task completed, enable the button
            startButton.isEnabled = true
            // Handle button click to start the main activity
            startButton.setOnClickListener {
                // To test inventory activity
                // val intent = Intent(this, MainActivity::class.java)
                // startActivity(intent)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)


                // To test maps activity
                //val intent = Intent(this, MapsActivity::class.java)
                //startActivity(intent)
                finish() // Close the loading activity
            }
        }, 300) // Adjust the delay as needed
    }
}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_login)
//
//        // Additional logic for your UserLogin activity
//    }