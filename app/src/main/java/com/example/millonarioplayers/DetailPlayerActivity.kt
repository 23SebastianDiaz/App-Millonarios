package com.example.millonarioplayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.millonarioplayers.databinding.ActivityDetailPlayerBinding

class DetailPlayerActivity : AppCompatActivity() {

    companion object{
        const val KEY_PLAYER = "key_player"
    }

    private lateinit var binding:ActivityDetailPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initIntent()

    }

    private fun initIntent() {

        val name = intent.getStringExtra("key_name")
        val photo = intent.getStringExtra("key_photo")
        val bibiography = intent.getStringExtra("key_bibiography")
        val nationality = intent.getStringExtra("key_nationality")
        val dorsal = intent.getStringExtra("key_dorsal")
        val position = intent.getStringExtra("key_position")
        val cupBetplay = intent.getStringExtra("key_cupBetplay")

        binding.tvPlayerNameDetail.text = name
        binding.tvPlayerBibiographyDetail.text = bibiography
        binding.tvPlayerNationalityDetail.text = nationality
        binding.tvPlayerPositionDetail.text = position
        binding.tvPlayerDorsalDetail.text = dorsal
        binding.tvCupNumber.text = cupBetplay
        Glide.with(this).load(photo).into(binding.ivPlayer)
    }

}