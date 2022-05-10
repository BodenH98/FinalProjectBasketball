package com.example.finalprojectbasketball

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayerService {
    @GET("players/{ID}")
    fun getPlayers(@Path("ID")id:Int): Call<List<Player>>
}