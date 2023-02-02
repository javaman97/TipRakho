package com.example.tiprakho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiprakho.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit  var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val costOfService=binding.costOfService.text.toString()
        val cost= costOfService.toDouble()
        val selectedId=binding.tipOptions.checkedRadioButtonId

        val tipPercentage= when(selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip= tipPercentage*cost
        val roundUp = binding.switchToggle.isChecked
         if(roundUp){
             tip=kotlin.math.ceil(tip)
         }
        val formattedTip=NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text=getString(R.string.tip_amount, formattedTip)
    }
}