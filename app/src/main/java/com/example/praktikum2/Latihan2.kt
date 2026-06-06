package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rbBiru = findViewById<RadioButton>(R.id.rbBiru)
        val rbHijau = findViewById<RadioButton>(R.id.rbHijau)
        val rbMerah = findViewById<RadioButton>(R.id.rbMerah)
        val btProsesLatihanWarna = findViewById<Button>(R.id.btProsesLatihanWarna)

        btProsesLatihanWarna.setOnClickListener {
            if (rbBiru.isChecked) {
                btProsesLatihanWarna.setBackgroundColor(ContextCompat.getColor(this, R.color.Biru))
            } else if (rbHijau.isChecked) {
                btProsesLatihanWarna.setBackgroundColor(ContextCompat.getColor(this, R.color.Hijau))
            } else if (rbMerah.isChecked) {
                btProsesLatihanWarna.setBackgroundColor(ContextCompat.getColor(this, R.color.Merah))
            }
        }
    }
}