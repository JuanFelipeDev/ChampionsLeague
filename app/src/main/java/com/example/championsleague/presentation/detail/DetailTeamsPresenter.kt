package com.example.championsleague.presentation.detail

import android.content.Intent
import com.example.championsleague.presentation.base.BasePresenterImpl
import com.example.championsleague.tools.Constants

class DetailTeamsPresenter : BasePresenterImpl<DetailTeamContract.View>(),
    DetailTeamContract.Presenter {

    override fun getExtras(intent: Intent) {
        val teamName = intent.extras?.getString(Constants.NAME_TEAM) ?: ""
        val teamDescription = intent.extras?.getString(Constants.DESCRIPTION_TEAM) ?: ""
        val yearFoundation = intent.extras?.getString(Constants.YEAR_FOUNDATION_TEAM) ?: ""
        val badgeTeam = intent.extras?.getString(Constants.BADGE_TEAM) ?: ""
        val jerseyTeam = intent.extras?.getString(Constants.JERSEY_TEAM) ?: ""
        val webPageYoutube = intent.extras?.getString(Constants.WEB_YOUTUBE) ?: ""
        val webPageOfficial = intent.extras?.getString(Constants.WEB_OFFICIAL) ?: ""
        val webPageFacebook = intent.extras?.getString(Constants.WEB_FACEBOOK) ?: ""
        val webPageTwitter = intent.extras?.getString(Constants.WEB_TWITTER) ?: ""
        val webPageInstagram = intent.extras?.getString(Constants.WEB_INSTAGRAM) ?: ""
        mView?.setDataExtras(
            teamName,
            teamDescription,
            yearFoundation,
            badgeTeam,
            jerseyTeam,
            webPageYoutube,
            webPageOfficial,
            webPageFacebook,
            webPageTwitter,
            webPageInstagram
        )
    }
}