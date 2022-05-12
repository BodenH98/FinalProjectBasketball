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
    private lateinit var gameRules: GameRules
    private lateinit var adapter: FinalProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mysteryPlayer: Player
        val basketballApi = RetrofitHelper.getInstance().create(PlayerService::class.java)
        val basketballCall = basketballApi.getPlayers(gameRules.random)
        basketballCall.enqueue(object: Callback<List<Player>>{
            override fun onResponse(
                call: Call<List<Player>>,
                response: Response<List<Player>>)
            {
                response.body()
                Log.d(TAG,"onResponse ${response.body()}")
                var playerList = response.body() ?: listOf<Player>()
                    adapter = FinalProjectAdapter(playerList)
                binding.basketballRecyclerView.adapter = adapter
                binding.basketballRecyclerView.layoutManager =
                    LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
               Log.d(TAG,"onFailure ${t.message}")
            }
        })
    }

    fun loadTargetPlayer() {
        // make the retrofit call

    }
}