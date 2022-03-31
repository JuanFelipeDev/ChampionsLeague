package com.example.championsleague.presentation.list

import com.example.championsleague.R
import com.example.championsleague.model.ResponseList
import com.example.championsleague.net.ApiManager
import com.example.championsleague.presentation.base.BaseApplication
import com.example.championsleague.presentation.base.BasePresenterImpl
import com.example.championsleague.tools.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListTeamsPresenter : BasePresenterImpl<ListTeamsContract.View>(),
    ListTeamsContract.Presenter {
    override fun getTeams() {
        ApiManager.getTeams().enqueue(object : Callback<ResponseList> {
            override fun onFailure(call: Call<ResponseList>, t: Throwable) {
                mView?.listError(BaseApplication.instance.getString(R.string.api_error))
            }

            override fun onResponse(
                call: Call<ResponseList>,
                response: Response<ResponseList>
            ) {
                if (response.isSuccessful) {
                    if (response.code() == Constants.RESPONSE_SUCCESS_200) {
                        val list: ResponseList? = response.body()
                        if (list != null) {
                            val listTeam = list.teams
                            mView?.setListTeams(listTeam)
                        }
                    } else {
                        mView?.listError(response.message())
                    }
                } else {
                    mView?.listError(response.message())
                }
            }
        })
    }
}