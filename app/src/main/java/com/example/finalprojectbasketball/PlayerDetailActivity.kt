package com.example.finalprojectbasketball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectbasketball.databinding.ActivityPlayerDetailBinding

class PlayerDetailActivity : AppCompatActivity(){
    private  lateinit var  binding: ActivityPlayerDetailBinding
    companion object{
        val EXTRA_PLAYER = "player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        binding.textViewGuessedAge.text = player?.
    }
}