package com.example.layout_pertemuan3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.layout_pertemuan3.databinding.ActivityDetailFotoBinding

class DetailFotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailFotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi binding
        binding = ActivityDetailFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Terima data dari Intent MainActivity
        val namaAkun = intent.getStringExtra("extra_name")
        // Gunakan getIntExtra karena referensi drawable (R.drawable...) berupa angka Integer
        val fotoProfil = intent.getIntExtra("extra_foto", 0)

        // Pasang data ke komponen XML
        with(binding) {
            // Set teks username
            tvUsername.text = namaAkun

            // Set foto profil
            if (fotoProfil != 0) {
                ivProfile.setImageResource(fotoProfil)
            }

            btnBack.setOnClickListener {
                finish() // Menutup halaman detail dan kembali ke MainActivity
            }
        }
    }
}