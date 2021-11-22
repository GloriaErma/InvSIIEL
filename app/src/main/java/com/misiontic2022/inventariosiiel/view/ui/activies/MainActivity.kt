package com.misiontic2022.inventariosiiel.view.ui.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.misiontic2022.inventariosiiel.R
import com.misiontic2022.inventariosiiel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // primer paso de ciclo vida
    // on destroy
    private val TAG = "MyActivity"
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        // se incluye las siguientes lineas..
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configNav()
// /////   }

        // Aglutinar recursos
        Log.d(TAG, "***** onCreate1.......")
//        val home1 = findViewById<TextView>(R.id.home1)
//        home1.text = "****Second GECS Hello World Android Studio!"

        Log.d(TAG, "******onCreate2.......")
        // botton action, recuperar las dos vistas
//        setContentView(R.layout.fragment_admin)
//        val usuario = findViewById<EditText>(R.id.Username)
//        val Password = findViewById<EditText>(R.id.Password)
//        val inicioButton = findViewById<Button>(R.id.inicioButton)
//        // enviar un toast en pantalla cuando acciona boton inicioButton
//        inicioButton.setOnClickListener{
//            Log.d("MainActivity", "*****!!Button Clicked!!*****")
//            // GECS :::: duración LENGTH_LONG/SHORT:: https://www.youtube.com/watch?v=hGrS3SmWvQI
//            // String template Kotlin, variables en una cadena de string
//            val msg = "Username Ingresado:  ${usuario.text}, Password Ingresado:  ${Password.text}"
//            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
//        }
    }
    fun configNav(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragContent) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bnvMenu).setupWithNavController(navController)
        Log.d(TAG, "******onCreate3......")
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