package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.fourth_task.*

const val WATCH_STATE = "watch_state"

class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private var onScreen = true

    private var backgroundThread = Thread {
        while (true) {
            Thread.sleep(1000)
            if (onScreen) {
                textSecondsElapsed.post {
                    textSecondsElapsed.text = "Seconds elapsed: " + secondsElapsed++
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "onCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth_task)
        backgroundThread.start()

        if (savedInstanceState != null) {
            secondsElapsed = savedInstanceState.getInt(WATCH_STATE, 0)
        }
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart called")
        onScreen = true
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
        onScreen = false
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(WATCH_STATE, secondsElapsed)
        Log.d("MainActivity", "onSaveInstanceState called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        secondsElapsed = savedInstanceState.getInt(WATCH_STATE)
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState called")
    }
}