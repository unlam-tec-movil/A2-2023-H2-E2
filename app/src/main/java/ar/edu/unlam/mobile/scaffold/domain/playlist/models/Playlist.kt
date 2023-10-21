package ar.edu.unlam.mobile.scaffold.domain.playlist.models

import androidx.annotation.DrawableRes

data class Playlist(
    val id: Long,
    val title: String,
    @DrawableRes val image: Int,
)
