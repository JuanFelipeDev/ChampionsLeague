package com.example.championsleague.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.championsleague.R
import com.example.championsleague.model.Team
import com.example.championsleague.presentation.base.BaseActivity
import com.example.championsleague.presentation.detail.DetailTeamActivity
import com.example.championsleague.presentation.items.adapter.ListTeamsAdapter
import com.example.championsleague.tools.Constants.BADGE_TEAM
import com.example.championsleague.tools.Constants.DESCRIPTION_TEAM
import com.example.championsleague.tools.Constants.JERSEY_TEAM
import com.example.championsleague.tools.Constants.NAME_TEAM
import com.example.championsleague.tools.Constants.WEB_FACEBOOK
import com.example.championsleague.tools.Constants.WEB_INSTAGRAM
import com.example.championsleague.tools.Constants.WEB_OFFICIAL
import com.example.championsleague.tools.Constants.WEB_TWITTER
import com.example.championsleague.tools.Constants.WEB_YOUTUBE
import com.example.championsleague.tools.Constants.YEAR_FOUNDATION_TEAM
import kotlinx.android.synthetic.main.activity_main.*

class ListTeamsActivity : BaseActivity<ListTeamsContract.View, ListTeamsContract.Presenter>(),
    ListTeamsContract.View, SearchView.OnQueryTextListener {

    override var mPresenter: ListTeamsContract.Presenter = ListTeamsPresenter()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mAdapterTeams: ListTeamsAdapter
    private var teamList: List<Team> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.getTeams()
        setUpListPockets()
    }

    private fun setUpListPockets() {
        linearLayoutManager = LinearLayoutManager(this)
        recyclerTeams.layoutManager = linearLayoutManager
        recyclerTeams.setHasFixedSize(true)
        mAdapterTeams = ListTeamsAdapter(teamList as ArrayList<Team>) { selectTeam ->
            val returnIntent = Intent(this, DetailTeamActivity::class.java)
            returnIntent.putExtra(NAME_TEAM, selectTeam.teamName)
            returnIntent.putExtra(DESCRIPTION_TEAM, selectTeam.teamDescription)
            returnIntent.putExtra(YEAR_FOUNDATION_TEAM, selectTeam.bornYear)
            returnIntent.putExtra(BADGE_TEAM, selectTeam.teamBadge)
            returnIntent.putExtra(JERSEY_TEAM, selectTeam.jerseyTeam)
            returnIntent.putExtra(WEB_YOUTUBE, selectTeam.pageYoutube)
            returnIntent.putExtra(WEB_OFFICIAL, selectTeam.pageWebOfficial)
            returnIntent.putExtra(WEB_FACEBOOK, selectTeam.pageFacebook)
            returnIntent.putExtra(WEB_TWITTER, selectTeam.pageTwitter)
            returnIntent.putExtra(WEB_INSTAGRAM, selectTeam.pageInstagram)
            startActivity(returnIntent)
        }
        recyclerTeams.adapter = mAdapterTeams
    }

    override fun listError(messageError: String) {
        showMessage(messageError)
    }

    override fun setListTeams(team: List<Team>) {
        mAdapterTeams.addItems(team)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_search_list, menu)
        val searchItem = menu?.findItem(R.id.search_view)
        val searchView = searchItem?.actionView as? SearchView
        searchView?.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean = false

    override fun onQueryTextChange(newText: String?): Boolean {
        mAdapterTeams.filter.filter(newText)
        return true
    }
}