package com.misiontic2022.inventariosiiel.view.ui.activies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val intent = Intent(this,MainActivity::class.java)

        animation.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
               }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

    }
}