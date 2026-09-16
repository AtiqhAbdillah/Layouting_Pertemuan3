package com.example.layout_pertemuan3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.layout_pertemuan3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
            if(result.resultCode == Activity.RESULT_OK) {
                //mengambil data intent
                val data = result.data

                //mendapatkan username dan bio dari data intent
                val name = data?.getStringExtra("extra_name")
                val bio = data?.getStringExtra("extra_bio")

                //menetapkan teks di Textview
                binding.tvUsername.text = "$name"
                binding.tvBio.text = "$bio"
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisiasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        //set ui content
        setContentView(binding.root)

        //terima data dari edit
        val name = intent.getStringExtra("extra_name")
        val bio = intent.getStringExtra("extra_bio")

        //gunakan binding
        with(binding) {
            btnEditProfile.setOnClickListener {
                val intent = Intent(this@MainActivity, Edit::class.java)
                    .apply { putExtra("extra_name", name) }
                    .apply { putExtra("extra_bio", bio) }
                launcher.launch(intent)
            }

            ivProfile.setOnClickListener {
                val intent = Intent(this@MainActivity, DetailFotoActivity::class.java)

                intent.putExtra("extra_name", tvUsername.text.toString())

                intent.putExtra("extra_foto", R.drawable.photo_profile)

                startActivity(intent)
            }
        }
    }
}