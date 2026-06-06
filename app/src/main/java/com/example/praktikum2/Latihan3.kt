package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner = findViewById<Spinner>(R.id.spinner)
        val btProsesLatihanWarna2 = findViewById<Button>(R.id.btProsesLatihanWarna2)

        btProsesLatihanWarna2.setOnClickListener {
            val pilihan = spinner.selectedItem.toString()
            when (pilihan) {
                "Merah" ->
                    btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.Merah))
                "Hijau" ->
                    btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.Hijau))
                "Biru" ->
                    btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor(this, R.color.Biru))
                else -> {
                    val builder = AlertDialog.Builder(this)
                    builder
                        .setTitle("Peringatan")
                        .setMessage("Warna akan direset ke awal, apakah anda yakin?")
                        .setPositiveButton("OK") {
                            dialog, _ ->
                            dialog.dismiss()
                            btProsesLatihanWarna2.setBackgroundColor(ContextCompat.getColor (this, R.color.purple_500))
                        }
                        .setNegativeButton("Batal") {
                            dialog, _ -> dialog.dismiss()
                        }
                        .show()
                }
            }
        }
    }
}