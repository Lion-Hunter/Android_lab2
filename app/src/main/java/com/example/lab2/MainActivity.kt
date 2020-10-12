package com.example.lab2

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "onCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart called")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPaused called")
        super.onPause()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d("MainActivity", "onRestart called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy called")
        super.onDestroy()
    }
}