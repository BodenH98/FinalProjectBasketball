package com.example.finalprojectbasketball

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectbasketball.databinding.ActivityPlayerDetailBinding

class PlayerDetailActivity : AppCompatActivity(){
    private  lateinit var  binding: ActivityPlayerDetailBinding
    companion object{
        val EXTRA_PLAYER = "player"
        val EXTRA_TEAM = "team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        val team = intent.getParcelableExtra<Team>(EXTRA_TEAM)
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