package com.example.championsleague.presentation.items.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.championsleague.model.Team
import com.example.championsleague.tools.Tools
import kotlinx.android.synthetic.main.holder_adapter.view.*

class ListTeamsHolder(v: View) : RecyclerView.ViewHolder(v) {

    private val view: View = v

    fun binItem(listTeam: Team, listener: (Team) -> Unit) = with(view) {
        view.txtNameTeam.text = listTeam.teamName
        Tools.loadImages(listTeam.stadiumImage, view.imgStadium)
        Tools.loadImages(listTeam.teamBadge, view.imgBadge)
        setOnClickListener { listener(listTeam) }
    }
}