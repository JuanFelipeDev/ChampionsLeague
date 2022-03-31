package com.example.championsleague.net

import com.example.championsleague.model.ResponseList
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(ApiExtension.APP_EXTENSION)
    fun getTeams(): Call<ResponseList>

}