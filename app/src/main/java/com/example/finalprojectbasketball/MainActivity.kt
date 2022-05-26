package com.example.finalprojectbasketball

import android.content.ContentValues.TAG
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprojectbasketball.databinding.ActivityMainBinding
import com.example.finalprojectbasketball.databinding.ActivityPlayerDetailBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FinalProjectAdapter
    private lateinit var viewHolder: FinalProjectAdapter.ViewHolder
    private lateinit var targetPlayer: Player
    private lateinit var playerguess: Player


    //TODO: Make the format of the player detail activity two columns instead of two rows.
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadTargetPlayer()
    }


    fun loadTargetPlayer() {
        // make the retrofit call
        val basketballApi = RetrofitHelper.getInstance().create(PlayerService::class.java)
        val basketballCall = basketballApi.getPlayerbyId(Random())
        basketballCall.enqueue(object : Callback<Player> {
            override fun onResponse(
                call: Call<Player>,
                response: Response<Player>

            ) {
                targetPlayer = response.body()!!

                if (targetPlayer.height_inches == 0 && targetPlayer.height_feet ==0 || targetPlayer.position == null  ) {
                    loadTargetPlayer()
                } else {
                    // have all this code inside the if
                    // in the else, call the function that has all this code in it
                    Log.d(TAG, "onResponse ${response.body()}")
                    var playerList = mutableListOf<Player>()
                    adapter = FinalProjectAdapter(playerList, targetPlayer)
                    binding.basketballRecyclerView.adapter = adapter
                    binding.basketballRecyclerView.layoutManager =
                        LinearLayoutManager(this@MainActivity)

                    binding.buttonMainActivityGuess.setOnClickListener {
                        val basketballCall2 =
                            basketballApi.getPlayerbyname(binding.editTextGuessPlayer.text.toString())
                        basketballCall2.enqueue(object : Callback<PlayerSearchWrapper> {
                            override fun onResponse(
                                call: Call<PlayerSearchWrapper>,
                                response: Response<PlayerSearchWrapper>
                            ) {

                                var meta = response.body()!!.meta
                                Log.d(TAG, "onResponse ${response.body()}")
                                if (meta.total_count == 0) {
                                    Toast.makeText(this@MainActivity, "Invalid player", LENGTH_LONG)
                                        .show()
                                } else if (meta.total_count > 1) {
                                    Toast.makeText(
                                        this@MainActivity, "Too many players with that name!",
                                        LENGTH_LONG
                                    ).show()
                                } else {
                                    playerguess = response.body()!!.data[0]
                                    playerList.add(playerguess)
                                    adapter = FinalProjectAdapter(playerList, targetPlayer)
                                    binding.basketballRecyclerView.adapter = adapter
                                    binding.basketballRecyclerView.layoutManager =
                                        LinearLayoutManager(this@MainActivity)
                                    binding.editTextGuessPlayer.setText("")
                                    if (playerguess == (targetPlayer)) {
                                        Toast.makeText(this@MainActivity, "you win!", LENGTH_LONG)
                                            .show()
                                    }

                                }

                            }

                            override fun onFailure(call: Call<PlayerSearchWrapper>, t: Throwable) {
                                Log.d(TAG, "onFailureSearch ${t.message}")
                            }

                        })
                        // find the player they typed in (using search by name)
                        // make another call
                        // add it to the list
                        // update the adapter
                        // check if this player matches the target player
                    }

                }
            }

            override fun onFailure(call: Call<Player>, t: Throwable) {
                Log.d(TAG, "onFailure ${t.message}")
            }
        })
    }

    fun Random(): Int {
        return ((Math.random() * 3092) + 1).toInt()
    }
}

