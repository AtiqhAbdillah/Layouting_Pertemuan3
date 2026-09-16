package com.example.layout_pertemuan3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout_pertemuan3.databinding.ActivityEditBinding

class Edit : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisiasi binding
        binding = ActivityEditBinding.inflate(layoutInflater)

        //setup ui content
        setContentView(binding.root)

        //gunakan binding
        with(binding) {

            btnBack.setOnClickListener {
                setResult((Activity.RESULT_CANCELED))

                finish()
            }

            //handle button elemen
            //kirim result ke activity yang memanggil
            btnSave.setOnClickListener {
                //inisiasi yang mau dikirim balik
                val resultIntent = Intent()

                //masukkan data username ke intent
                resultIntent.putExtra("extra_name", edtNama.text.toString())

                //masukkan nama ke bio
                resultIntent.putExtra("extra_bio", edtBio.text.toString())

                //set result code dari atas
                setResult(Activity.RESULT_OK, resultIntent)

                //menyelesaikan activity result / completion
                finish()
            }
        }

    }
}