package com.example.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.githubuserapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashScreenBinding
    private val second = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
               super.onCreate(savedInstanceState)
            binding = ActivitySplashScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                finish()
            }, second)


        }
    }
