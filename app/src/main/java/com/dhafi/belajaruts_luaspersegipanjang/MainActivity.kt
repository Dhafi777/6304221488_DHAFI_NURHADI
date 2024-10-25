package com.dhafi.belajaruts_luaspersegipanjang

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.Activity
import android.content.Intent
import com.dhafi.belajaruts_luaspersegipanjang.databinding.ActivityMainBinding

const val SECOND_ACTIVITY = 1000

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val sisi = binding.inputSisi.text.toString().toDouble()

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            val bundle = Bundle()
            bundle.putDouble("sisi", sisi)
            intent.putExtra("kubus_data", bundle)
            startActivityForResult(intent, 1)  // Request code = 1
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            val area = data?.getDoubleExtra("calculated_area", 0.0)
            val area2 = data?.getDoubleExtra("calculated_area", 0.0)
            binding.txtResult.text = "Luas Permukaan Kubus: $area cm"
            binding.txtResult2.text = "Volume Kubus: $area2 cm"
        }
    }
}
