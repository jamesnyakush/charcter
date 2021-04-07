package com.example.e_movieapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.e_movieapp.R
import dagger.hilt.android.AndroidEntryPoint
import android.os.Handler as Handler1

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        //4second splash time
       Handler1().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
            //finish this activity
            finish()
        },4000)

    }
}