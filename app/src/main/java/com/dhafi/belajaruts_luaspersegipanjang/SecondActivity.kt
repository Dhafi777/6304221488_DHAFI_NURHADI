package com.dhafi.belajaruts_luaspersegipanjang

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.Activity
import android.content.Intent
import com.dhafi.belajaruts_luaspersegipanjang.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.getBundleExtra("kubus_data")
        val sisi = bundle?.getDouble("sisi")

        binding.txtDimensions.text = "Panjang sisi: $sisi"

        binding.btnCalculateArea.setOnClickListener {
            val area = 6 * sisi!!
            val area2 = sisi!! * (sisi!! * sisi!!)
            val resultIntent = Intent()

            resultIntent.putExtra("calculated_area", area)
            resultIntent.putExtra("calculated_area", area2)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
