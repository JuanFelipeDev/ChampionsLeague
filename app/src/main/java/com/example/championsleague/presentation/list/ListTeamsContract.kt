package com.example.championsleague.presentation.list

import com.example.championsleague.model.Team
import com.example.championsleague.presentation.base.BasePresenter
import com.example.championsleague.presentation.base.BaseView

object ListTeamsContract {

    interface View : BaseView {
        fun listError(messageError: String)
        fun setListTeams(team: List<Team>)
    }

    interface Presenter : BasePresenter<View> {
        fun getTeams()
    }
}