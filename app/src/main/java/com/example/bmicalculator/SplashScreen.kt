package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.window.SplashScreen
import com.example.bmicalculator.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        binding=ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        Handler(Looper.getMainLooper()).postDelayed({
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()},1000)

    }


}