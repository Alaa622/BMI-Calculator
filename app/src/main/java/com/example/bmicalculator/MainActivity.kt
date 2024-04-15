package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater,)
        setContentView(binding.root)

        setClickListeners()
    }

       private fun setClickListeners() {
        binding.btnCalculate.setOnClickListener {
            binding.cvResult.visibility = INVISIBLE
            val weight = binding.etWeight.text.toString()
            val height = binding.etHeight.text.toString()

            if (checkInputsValidation(weight, height)) {
                binding.cvResult.visibility = VISIBLE
                val bmi = calculateBmi(weight.toFloat(), height.toFloat())
                display(bmi)
            }
        }

    }

    private fun checkInputsValidation(weight: String, height: String): Boolean {
        return when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Please, Enter your weight", Toast.LENGTH_SHORT).show()
                return false
            }

            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Please, Enter your height", Toast.LENGTH_SHORT).show()
                return false
            }

            else -> {
                return true
            }

        }
    }

    private fun calculateBmi(weight: Float, height: Float): Float {
        val bmi = weight.toFloat() / (height.toFloat() / 100 * height.toFloat() / 100)
        val bmi2Digits = String.format("%.2f", bmi).toFloat()
        return bmi2Digits
    }

    private fun display(bmi: Float) {

        binding.tvIndex.text = bmi.toString()
        binding.tvInfo.text = "Normal range is 18.5 - 24.9"

        var result = ""
        var color = 0
        when {
            bmi < 18.50 -> {
                result = "Underweight"
                color = R.color.UnderWeight
            }

            bmi in 25.00..29.99 -> {
                result = "Overweight"
                color = R.color.OverWeight_Obese
            }

            bmi in 18.50..24.99 -> {
                result = "You are healthy!"
                color = R.color.Healthy
            }

            bmi > 29.99 -> {
                result = "Obese"
                color = R.color.OverWeight_Obese
            }
        }
        binding.tvResult.text = result
        binding.tvResult.setTextColor(getColor(color))

    }
}

