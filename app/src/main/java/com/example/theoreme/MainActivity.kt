package com.example.theoreme

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.theoreme.databinding.ActivityMainBinding
import com.example.theoreme.ui.theme.TheoremeTheme
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.sqrt


//TODO какая-то херня с инфлэйтором и темой, типа все красиво, только не работает

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val result = getString(R.string.result_info) + getResult()
            binding.result.text = result
        }
    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if(valueA.text.isNullOrEmpty()) valueA.error = "must be filled"
            if(valueB.text.isNullOrEmpty()) valueB.error = "must be filled"
            return valueA.text.isNullOrEmpty() || valueB.text.isNullOrEmpty()
        }
    }
    private fun getResult() : String {
        val a: Double
        val b: Double
        binding.apply {
            a = valueA.text.toString().toDouble()
            b = valueB.text.toString().toDouble()

        }
        val r = sqrt((a.pow(2) + b.pow(2))).toBigDecimal().scale().toString()
        return r
    }
}