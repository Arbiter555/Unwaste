package com.example.unwaste

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.unwaste.R
import com.example.unwaste.databinding.ActivityMainBinding

import com.example.unwaste.databinding.FragmentLoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        // Additional logic for your UserLogin activity
    }
}

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_login)
//
//        // Additional logic for your UserLogin activity
//    }