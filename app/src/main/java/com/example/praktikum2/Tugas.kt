package com.example.praktikum2 // Sesuaikan dengan package kamu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Tugas : AppCompatActivity() {

    // Variabel untuk menyimpan status lampu (false = mati, true = nyala)
    private var isLampOn: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tugas)

        // Inisialisasi View
        val imgLampu = findViewById<ImageView>(R.id.imgLampu)
        val btnSwitch = findViewById<Button>(R.id.btnSwitch)
        val rgWarna = findViewById<RadioGroup>(R.id.rgWarna)
        val rbPutih = findViewById<RadioButton>(R.id.rbPutih)
        val rbKuning = findViewById<RadioButton>(R.id.rbKuning)
        val rbBiru = findViewById<RadioButton>(R.id.rbBiru)

        // Fungsi internal untuk memperbarui gambar lampu berdasarkan pilihan warna
        fun updateLampu() {
            if (isLampOn) {
                // Jika lampu menyala, cek warna mana yang dipilih
                when {
                    rbPutih.isChecked -> imgLampu.setImageResource(R.drawable.ic_lamp_light_on_white)
                    rbKuning.isChecked -> imgLampu.setImageResource(R.drawable.ic_lamp_light_on_yellow)
                    rbBiru.isChecked -> imgLampu.setImageResource(R.drawable.ic_lamp_light_on_blue)
                }
            } else {
                // Jika lampu mati, selalu tampilkan gambar off
                imgLampu.setImageResource(R.drawable.ic_lamp_light_off)
            }
        }

        // Listener untuk Tombol Power
        btnSwitch.setOnClickListener {
            isLampOn = !isLampOn // Membalikkan status (true jadi false, false jadi true)

            if (isLampOn) {
                btnSwitch.text = "TURN OFF"
            } else {
                btnSwitch.text = "TURN ON"
            }
            updateLampu()
        }

        // Listener untuk Perubahan RadioButton
        rgWarna.setOnCheckedChangeListener { _, _ ->
            if (isLampOn) {
                updateLampu()
            } else {
                // Opsional: Kasih peringatan kalau lampu belum nyala
                Toast.makeText(this, "Lampu masih mati, silakan nyalakan!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}