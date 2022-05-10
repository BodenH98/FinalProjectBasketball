package com.example.finalprojectbasketball

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerService {
    @GET("players")
    fun getPlayers(@Query("ID")search:String): Call<List<Player>>
}