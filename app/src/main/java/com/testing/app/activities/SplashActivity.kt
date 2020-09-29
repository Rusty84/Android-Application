package com.testing.app.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.testing.app.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }, SPLASH_TIME_OUT)
    }
}