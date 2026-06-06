package com.example.praktikum2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Latihan5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etSisiKubus = findViewById<EditText>(R.id.etSisiKubus)
        val cbLuasPersegi = findViewById<CheckBox>(R.id.cbPilihan1)
        val cbLuasPermukaanKubus = findViewById<CheckBox>(R.id.cbPilihan2)
        val cbVolumeKubus = findViewById<CheckBox>(R.id.cbPilihan3)
        val btnProses = findViewById<Button>(R.id.btnProsesCheckBox)
        val tvHasil = findViewById<TextView>(R.id.tvHasilCheckBox)


        btnProses.setOnClickListener {
            val sisi = etSisiKubus.text.toString().trim().toIntOrNull() ?: 0
            val builder = AlertDialog.Builder(this)
            var hasil1 = sisi * sisi
            var hasil2 = 6 * sisi * sisi
            var hasil3 = sisi * sisi * sisi

            if (cbLuasPersegi.isChecked && cbLuasPermukaanKubus.isChecked && cbVolumeKubus.isChecked) {
                tvHasil.text = "Luas Persegi = " + hasil1.toString() + " cm\u00B2" +
                        "\nLuas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2" +
                        "\nVolume Kubus = " + hasil3.toString() + " cm\u00B3"
            } else if (cbLuasPersegi.isChecked && cbLuasPermukaanKubus.isChecked) {
                tvHasil.text = "Luas Persegi = " + hasil1.toString() + " cm\u00B2" +
                        "\nLuas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2"
            } else if (cbLuasPermukaanKubus.isChecked && cbVolumeKubus.isChecked) {
                tvHasil.text = "Luas Permukaan Kubus = " + hasil2.toString() + " cm\u00B2" +
                        "\nVolume Kubus = " + hasil3.toString() + " cm\u00B3"
            } else if (cbLuasPersegi.isChecked && cbVolumeKubus.isChecked) {
                tvHasil.text = "Luas Persegi = " + hasil1.toString() + " cm\u00B2" +
                        "\nVolume Kubus = " + hasil3.toString() + " cm\u00B3"
            } else {
                builder.setTitle("Peringatan")
                builder.setMessage("Silahkan Centang Dua Pilihan")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.show()
                tvHasil.text = "------"
            }
        }

    }
}