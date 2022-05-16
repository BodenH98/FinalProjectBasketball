package com.example.finalprojectbasketball

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprojectbasketball.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FinalProjectAdapter
    private lateinit var viewHolder: FinalProjectAdapter.ViewHolder
    private lateinit var targetPlayer : Player
    private lateinit var playerguess:Player


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        fun Random():Int{
            return ((Math.random()*3092)+1).toInt()
        }


        val basketballApi = RetrofitHelper.getInstance().create(PlayerService::class.java)
        val basketballCall = basketballApi.getPlayerbyId(Random())

        basketballCall.enqueue(object: Callback<Player>{
            override fun onResponse(
                call: Call<Player>,
                response: Response<Player>)
            {
                targetPlayer = response.body()!!
                Log.d(TAG,"onResponse ${response.body()}")
                var playerList = mutableListOf<Player>()
                    adapter = FinalProjectAdapter(playerList)
                binding.basketballRecyclerView.adapter = adapter
                binding.basketballRecyclerView.layoutManager =
                    LinearLayoutManager(this@MainActivity)

                binding.buttonMainActivityGuess.setOnClickListener {
                    val basketballCall2 = basketballApi.getPlayerbyname(binding.editTextGuessPlayer.text.toString())
                    basketballCall2.enqueue(object : Callback<List<Player>> {
                        override fun onResponse(
                            call: Call<List<Player>>,
                            response: Response<List<Player>>
                        ) {
                            playerguess = response.body()!![0]
                            Log.d(TAG,"onResponse ${response.body()}")
                            playerList.add(playerguess)
                            adapter = FinalProjectAdapter(playerList)
                            binding.basketballRecyclerView.adapter = adapter
                            binding.basketballRecyclerView.layoutManager =
                                LinearLayoutManager(this@MainActivity)
                        }

                        override fun onFailure(call: Call<List<Player>>, t: Throwable) {
                            Log.d(TAG,"onFailureSearch ${t.message}")
                        }

                    })
                    // find the player they typed in (using search by name)
                    // make another call
                    // add it to the list
                    // update the adapter
                    // check if this player matches the target player
                }

            }

            override fun onFailure(call: Call<Player>, t: Throwable) {
               Log.d(TAG,"onFailure ${t.message}")
            }
        })
    }

    fun loadTargetPlayer() {
        // make the retrofit call

    }
}