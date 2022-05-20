package com.example.finalprojectbasketball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectbasketball.databinding.ActivityPlayerDetailBinding

class PlayerDetailActivity : AppCompatActivity(){
    lateinit var  binding: ActivityPlayerDetailBinding
    private lateinit var playerguess:Player
    companion object{
        val EXTRA_PLAYER = "player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        var team = player?.team
        binding.textViewGuessedConference.text = team?.conference
        binding.textViewGuessedDivision.text = team?.division
        binding.textViewGuessedHeightFt.text = player?.height_feet.toString()
        binding.textViewGuessedHeightIn.text = player?.height_inches.toString()
        binding.textViewGuessedFirstname.text = player?.first_name
        binding.textViewGuessedLastname.text = player?.last_name
        binding.textViewGuessedPosition.text = player?.position
        binding.textViewGuessedTeam.text = team?.name

    }
}