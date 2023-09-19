package ar.edu.unlam.mobile.scaffold.domain.kitty.models

import androidx.annotation.DrawableRes

data class Song(
    val title: String,
    val artist: String,
    @DrawableRes val coverArt: Int
)