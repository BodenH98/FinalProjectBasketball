package com.example.finalprojectbasketball

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectbasketball.databinding.ActivityPlayerDetailBinding

class PlayerDetailActivity : AppCompatActivity(){
    lateinit var  binding: ActivityPlayerDetailBinding
    private lateinit var playerguess:Player
    companion object{
        val EXTRA_PLAYER = "player"
        val EXTRA_TARGET = "targetplayer"
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

        val targetPlayer = intent.getParcelableExtra<Player>(EXTRA_TARGET)
        if(playerguess.first_name.equals(targetPlayer?.first_name)){
            binding.textViewGuessedFirstname.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.last_name.equals(targetPlayer?.last_name)){
            binding.textViewGuessedLastname.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.team.name.equals(targetPlayer?.team?.name)){
            binding.textViewGuessedTeam.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.team.division.equals(targetPlayer?.team?.division)){
            binding.textViewGuessedDivision.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.team.conference.equals(targetPlayer?.team?.conference)){
            binding.textViewGuessedConference.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.position.equals(targetPlayer?.position)){
            binding.textViewGuessedPosition.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.height_feet.equals(targetPlayer?.height_feet)){
            binding.textViewGuessedHeightFt.setTextColor(
                Color.GREEN
            )
        }
        if(playerguess.height_inches.equals(targetPlayer?.height_inches)){
            binding.textViewGuessedHeightIn.setTextColor(
                Color.GREEN
            )
        }
    }
}