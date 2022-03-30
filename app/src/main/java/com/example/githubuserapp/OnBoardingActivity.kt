package com.example.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubuserapp.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity(){

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.buttonOnboard.setOnClickListener{
                val moveIntent = Intent(this@OnBoardingActivity, SplashScreenActivity::class.java)
                startActivity(moveIntent)
            }
        }

    }

