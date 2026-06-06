package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvHasilLat1 = findViewById<TextView>(R.id.tvNIM1)
        val btProsesLat1 = findViewById<Button>(R.id.btProsesLat1)

        btProsesLat1.setOnClickListener {
            val nama = tvHasilLat1.text.toString()
            if (nama == "teal")
                tvHasilLat1.text = nama
            btProsesLat1.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
        }
    }
}