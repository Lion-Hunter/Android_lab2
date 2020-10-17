package com.example.lab2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fourth_task.*

const val WATCH_STATE = "watch_state"

class MainActivity : AppCompatActivity() {
    private var secondsElapsed: Int = 0
    private var onScreen = true
    private val TAG = "MainActivity"

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
        Log.d(TAG, "onCreate called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fourth_task)
        backgroundThread.start()

        if (savedInstanceState != null) {
            secondsElapsed = savedInstanceState.getInt(WATCH_STATE, 0)
        }
    }

    override fun onStart() {
        Log.d(TAG, "onStart called")
        onScreen = true
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPaused called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop called")
        onScreen = false
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy called")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(WATCH_STATE, secondsElapsed)
        Log.d(TAG, "onSaveInstanceState called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        secondsElapsed = savedInstanceState.getInt(WATCH_STATE)
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState called")
    }
}