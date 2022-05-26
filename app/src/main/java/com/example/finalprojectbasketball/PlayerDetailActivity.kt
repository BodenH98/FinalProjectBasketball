package com.example.finalprojectbasketball

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalprojectbasketball.databinding.ActivityPlayerDetailBinding

class PlayerDetailActivity : AppCompatActivity(){
    lateinit var  binding: ActivityPlayerDetailBinding
    private lateinit var playerguess:Player
    private lateinit var adapter: FinalProjectAdapter

    companion object{
        val EXTRA_PLAYER = "player"
        val EXTRA_TARGET = "targetplayer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val guessedplayer = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        var guessedteam = guessedplayer?.team

        binding.textViewGuessedConference.text = guessedteam?.conference
        binding.textViewGuessedDivision.text = guessedteam?.division
        binding.textViewGuessedHeightFt.text = guessedplayer?.height_feet.toString()
        binding.textViewGuessedHeightIn.text = guessedplayer?.height_inches.toString()
        binding.textViewGuessedFirstname.text = guessedplayer?.first_name
        binding.textViewGuessedLastname.text = guessedplayer?.last_name
        binding.textViewGuessedPosition.text = guessedplayer?.position
        binding.textViewGuessedTeam.text = guessedteam?.name

        val targetPlayer = intent.getParcelableExtra<Player>(EXTRA_TARGET)
        var gueesedplayerheight=
            guessedplayer?.height_feet?.toInt()?.times(12)?.plus(guessedplayer?.height_inches)
        var targetPlayerheight = targetPlayer?.height_feet?.toInt()?.times(12)?.plus(targetPlayer?.height_inches!!)

        var heightdiff = targetPlayerheight?.let { gueesedplayerheight?.minus(it) }

        if(guessedplayer?.first_name == targetPlayer?.first_name){
            binding.textViewGuessedFirstname.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.last_name == targetPlayer?.last_name){
            binding.textViewGuessedLastname.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.team?.name == targetPlayer?.team?.name){
            binding.textViewGuessedTeam.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.team?.division == targetPlayer?.team?.division){
            binding.textViewGuessedDivision.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.team?.conference == targetPlayer?.team?.conference){
            binding.textViewGuessedConference.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.position == targetPlayer?.position){
            binding.textViewGuessedPosition.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.height_feet == (targetPlayer?.height_feet)){
            binding.textViewGuessedHeightFt.setTextColor(
                Color.GREEN
            )
        }
        if(guessedplayer?.height_inches == targetPlayer?.height_inches){
            binding.textViewGuessedHeightIn.setTextColor(
                Color.GREEN
            )
        }
        else if (heightdiff != null) {
            if(heightdiff>-2 && heightdiff<2){
                binding.textViewGuessedHeightIn.setTextColor(
                    Color.YELLOW
                )
            }
        }
    }
}




