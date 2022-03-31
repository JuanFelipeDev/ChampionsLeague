package com.example.championsleague.net

import com.example.championsleague.model.ResponseList
import retrofit2.Call

object ApiManager {

    fun getTeams(): Call<ResponseList> {
        return ApiClient.retrofitAdapter.create(ApiService::class.java)
            .getTeams()
    }
}