package ar.edu.unlam.mobile.scaffold.domain.models.search

data class Song(
    val title: String,
    val artist: String,
    val coverArt: String,
    val srcSpotify: String = "",
)
