package com.example.championsleague.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team(
    @SerializedName("strTeam") val teamName: String,
    @SerializedName("strStadium") val stadiumName: String,
    @SerializedName("intFormedYear") val bornYear: String,
    @SerializedName("strStadiumThumb") val stadiumImage: String,
    @SerializedName("strDescriptionES") val teamDescription: String,
    @SerializedName("strTeamBadge") val teamBadge: String,
    @SerializedName("strTeamJersey") val jerseyTeam: String,
    @SerializedName("strWebsite") val pageWebOfficial: String,
    @SerializedName("strFacebook") val pageFacebook: String,
    @SerializedName("strTwitter") val pageTwitter: String,
    @SerializedName("strInstagram") val pageInstagram: String,
    @SerializedName("strYoutube") val pageYoutube: String
) : Serializable
