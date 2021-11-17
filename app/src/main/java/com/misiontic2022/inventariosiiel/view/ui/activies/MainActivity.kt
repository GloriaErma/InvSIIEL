package com.misiontic2022.inventariosiiel.view.ui.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.misiontic2022.inventariosiiel.R

class MainActivity : AppCompatActivity() {
    // primer paso de ciclo vida
    // on destroy
    private val TAG = "MyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Aglutinar recursos
        Log.d(TAG, "onCreate")
        val home1 = findViewById<TextView>(R.id.home1)
        home1.text = "****Second GECS Hello World Android Studio!"

        Log.d(TAG, "onCreate")
    }
    override  fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }
    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }
    override  fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }
    override  fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}