package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etJumlahBebek = findViewById<EditText>(R.id.etJumlahBebek)
        val btnProsesBebek = findViewById<Button>(R.id.btnProsesBebek)
        val linearLayoutBebek = findViewById<LinearLayout>(R.id.linearLayoutBebek)

        btnProsesBebek.setOnClickListener {
            val input = etJumlahBebek.text.toString().toIntOrNull() ?: 0
            val jumlahBebek = input.coerceIn(1, 6)
            linearLayoutBebek.removeAllViews()

            for (i in 1..jumlahBebek) {
                val imageBebek = ImageView(this)
                imageBebek.setImageResource(R.drawable.ic_bebek) // Pastikan ada ic_bebek di drawable

                val params = LinearLayout.LayoutParams(150, 150)
                params.setMargins(5, 5, 5, 5)
                imageBebek.layoutParams = params

                linearLayoutBebek.addView(imageBebek)
            }
        }
    }
}