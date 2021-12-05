package com.misiontic2022.inventariosiiel.view.ui.activies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.misiontic2022.inventariosiiel.R
import com.misiontic2022.inventariosiiel.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private  lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val animation = AnimationUtils.loadAnimation(this, R.anim.animation)
        binding.ivSplahScreen.startAnimation(animation)
        // GECS
        // val intent = Intent(this,MainActivity::class.java)
        val intent = Intent(this, LoginActivity::class.java)

        animation.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
               }

            override fun onAnimationEnd(p0: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })
        Log.d("SplashScreenActivity", "******SplashScreenActivity......")
    }
}