// Day 11: Android Project Structure & Lifecycle
// Learn: App components, manifest file, activity lifecycle, resource management

package com.example.androidbasics

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private val TAG = "MainActivity"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called")
        
        // Initialize your views and setup here
        setupViews()
    }
    
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
        // Activity is becoming visible
    }
    
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
        // Activity is now interactive
    }
    
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
        // Activity is losing focus
    }
    
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
        // Activity is no longer visible
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
        // Activity is being destroyed
    }
    
    private fun setupViews() {
        // TODO: Initialize your UI components here
        // Example: findViewById<Button>(R.id.button).setOnClickListener { }
    }
}

// TODO: Practice with different activity lifecycle scenarios