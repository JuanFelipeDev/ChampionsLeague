package com.example.championsleague.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.example.championsleague.R
import com.example.championsleague.presentation.base.BaseActivity
import com.example.championsleague.tools.Tools
import kotlinx.android.synthetic.main.activity_detail_team.*

class DetailTeamActivity : BaseActivity<DetailTeamContract.View, DetailTeamContract.Presenter>(),
    DetailTeamContract.View {

    override var mPresenter: DetailTeamContract.Presenter = DetailTeamsPresenter()

    private var webYoutube: String = ""
    private var webOfficial: String = ""
    private var webFacebook: String = ""
    private var webTwitter: String = ""
    private var webInstagram: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)
        mPresenter.getExtras(intent)
        createLinks()
    }

    private fun createLinks() {
        val csYoutube = object : ClickableSpan() {
            override fun onClick(v: View) {
                val defaultBrowser =
                    Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(webYoutube)
                startActivity(defaultBrowser)
            }
        }

        Tools.createLink(
            txtUrlYoutube, webYoutube,
            webYoutube,
            csYoutube, ContextCompat.getColor(this, R.color.purple_700)
        )

        val csPageOfficial = object : ClickableSpan() {
            override fun onClick(v: View) {
                val defaultBrowser =
                    Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(webOfficial)
                startActivity(defaultBrowser)
            }
        }

        Tools.createLink(
            txtUrlWeb, webOfficial,
            webOfficial,
            csPageOfficial, ContextCompat.getColor(this, R.color.purple_700)
        )

        val csPageFacebook = object : ClickableSpan() {
            override fun onClick(v: View) {
                val defaultBrowser =
                    Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(webFacebook)
                startActivity(defaultBrowser)
            }
        }

        Tools.createLink(
            txtUrlFacebook, webFacebook,
            webFacebook,
            csPageFacebook, ContextCompat.getColor(this, R.color.purple_700)
        )

        val csPageTwitter = object : ClickableSpan() {
            override fun onClick(v: View) {
                val defaultBrowser =
                    Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(webTwitter)
                startActivity(defaultBrowser)
            }
        }

        Tools.createLink(
            txtUrlTwitter, webTwitter,
            webTwitter,
            csPageTwitter, ContextCompat.getColor(this, R.color.purple_700)
        )

        val csPageInstagram = object : ClickableSpan() {
            override fun onClick(v: View) {
                val defaultBrowser =
                    Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
                defaultBrowser.data = Uri.parse(webInstagram)
                startActivity(defaultBrowser)
            }
        }

        Tools.createLink(
            txtUrlInstagram, webInstagram,
            webInstagram,
            csPageInstagram, ContextCompat.getColor(this, R.color.purple_700)
        )

    }

    override fun setDataExtras(
        teamName: String,
        teamDescription: String,
        yearFoundation: String,
        badgeTeam: String,
        jerseyTeam: String,
        webPageYoutube: String,
        webPageOfficial: String,
        webPageFacebook: String,
        webPageTwitter: String,
        webPageInstagram: String
    ) {
        txtNameTeam.text = teamName
        if (teamDescription.isEmpty()) {
            labelDescription.visibility = View.GONE
        }
        txtDescription.text = teamDescription
        txtYearFoundation.text = yearFoundation
        Tools.loadImages(badgeTeam, imgBadge)
        Tools.loadImages(jerseyTeam, imgJersey)
        txtUrlWeb.text = webPageOfficial
        txtUrlFacebook.text = webPageFacebook
        txtUrlTwitter.text = webPageTwitter
        txtUrlInstagram.text = webPageInstagram
        txtUrlYoutube.text = webPageYoutube
        webOfficial = webPageOfficial
        webFacebook = webPageFacebook
        webTwitter = webPageTwitter
        webInstagram = webPageInstagram
        webYoutube = webPageYoutube
    }
}