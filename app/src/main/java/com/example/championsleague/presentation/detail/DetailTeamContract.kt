package com.example.championsleague.presentation.detail

import android.content.Intent
import com.example.championsleague.presentation.base.BasePresenter
import com.example.championsleague.presentation.base.BaseView

object DetailTeamContract {

    interface View : BaseView {
        fun setDataExtras(
            teamName: String,
            teamDescription: String,
            yearFoundation: String,
            badgeTeam: String,
            jerseyTeam: String,
            webPageYoutube:String,
            webPageOfficial: String,
            webPageFacebook: String,
            webPageTwitter: String,
            webPageInstagram: String
        )
    }

    interface Presenter : BasePresenter<View> {
        fun getExtras(intent: Intent)
    }
}