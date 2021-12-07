package com.misiontic2022.inventariosiiel.view.ui.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.misiontic2022.inventariosiiel.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.misiontic2022.inventariosiiel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        configNav()
    }

    fun configNav(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragContent) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bnvMenu).setupWithNavController(navController)
        Log.d("MyActivity", "******fun configNav......")
    }

    override fun onRequestPermissionsResult(
        requestCode:Int ,
        permissions: Array <out String>,
        grantResults: IntArray

    ){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permissionsToRequest= ArrayList<String>()
        var  i =0
        while (i < grantResults.size){
            permissionsToRequest.add(permissions[i])
            i++
        }
        if (permissionsToRequest.size>0){
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                REQUEST_PERMISSIONS_REQUEST_CODE
            )
        }

    }

}





//package com.misiontic2022.inventariosiiel.view.ui.activies
//
//import android.database.sqlite.SQLiteOpenHelper
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.Editable
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.fragment.app.FragmentActivity
//import androidx.navigation.fragment.NavHostFragment
//import androidx.navigation.fragment.findNavController
//import androidx.navigation.ui.setupWithNavController
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.misiontic2022.inventariosiiel.R
//import com.misiontic2022.inventariosiiel.databinding.ActivityMainBinding
//import android.text.Html
//import android.graphics.Color
//
//
//class MainActivity : AppCompatActivity() {
//    // primer paso de ciclo vida
//    // on destroy
//    private val TAG = "MyActivity"
//
//    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //setContentView(R.layout.activity_main)
// // /////   }
//        // Aglutinar recursos
//        Log.d(TAG, "***** onCreate1.......")
////        val home1 = findViewById<TextView>(R.id.home1)
////        home1.text = "****Second GECS Hello World Android Studio!"
//        // botton action, recuperar las dos vistas
//        setContentView(R.layout.fragment_home)
//        val usuario = findViewById<EditText>(R.id.Username)
//        val Password = findViewById<EditText>(R.id.Password)
//        val inicioButton = findViewById<Button>(R.id.inicioButton)
//        // enviar un toast en pantalla cuando acciona boton inicioButton
//        inicioButton.setOnClickListener{
//            Log.d("MainActivity", "*****!!Button Clicked!!*****")
//            // GECS :::: duración LENGTH_LONG/SHORT:: https://www.youtube.com/watch?v=hGrS3SmWvQI
//            // String template Kotlin, variables en una cadena de string
////            val msg = "Username Ingresado:  ${usuario.text}, Password Ingresado:  ${Password.text}"
////            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
//            if (!isPasswordValid(Password.text) || !isUserValid(usuario.text)) {
//                val msg = "Password must contain at least 8 characters Username Ingresado:  ${usuario.text}, Password Ingresado :  ${Password.text}"
//                val toast =
//                    Toast.makeText(this@MainActivity, "Enter at least 5 characters. Username logged in: ${usuario.text}??,Password logged in:  ${Password.text}??", Toast.LENGTH_LONG)
//                val view = toast.view
//                //To change the Background of Toast
//                view!!.setBackgroundColor(Color.TRANSPARENT)
//                val text = view!!.findViewById<View>(android.R.id.message) as TextView
//                //Shadow of the Of the Text Color
//                text.setShadowLayer(0f, 0f, 0f, Color.TRANSPARENT)
//                text.setTextColor(Color.RED)
//                //text.textSize = Integer.valueOf(resources.getString(com.misiontic2022.inventariosiiel.R.string.text_size)).toFloat()
//                toast.show()
//            } else {
//                val msg = "Username Ingresado:  ${usuario.text}, Password Ingresado EXITOSAMENTE:  ${Password.text}"
//                Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
//                // se incluye las siguientes lineas..implementar el paquete binding
//                // en cada uno de los fragments
//                lateinit var binding: ActivityMainBinding
//                binding = ActivityMainBinding.inflate(layoutInflater)
//                val view = binding.root
//
//                setContentView(view)
//                configNav()
//            }
//        }
//    }
//    private fun isPasswordValid(text: Editable?): Boolean {
//        return text != null && text.length >= 5
//    }
//    private fun isUserValid(text: Editable?): Boolean {
//        return text != null && text.length >= 5
//    }
//    fun configNav(){
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragContent) as NavHostFragment
//        val navController = navHostFragment.navController
//        findViewById<BottomNavigationView>(R.id.bnvMenu).setupWithNavController(navController)
//        Log.d(TAG, "******fun configNav from MainActivity.kt.....")
//    }
//    fun botonInicio(){
//
//
//    }
//
//
//    override  fun onStart() {
//        Log.d(TAG, "onStart")
//        super.onStart()
//    }
//    override fun onResume() {
//        Log.d(TAG, "onResume")
//        super.onResume()
//    }
//    override fun onPause() {
//        Log.d(TAG, "onPause")
//        super.onPause()
//    }
//    override  fun onStop() {
//        Log.d(TAG, "onStop")
//        super.onStop()
//    }
//    override  fun onDestroy() {
//        Log.d(TAG, "onDestroy")
//        super.onDestroy()
//    }
//}
//
