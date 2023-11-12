package ar.edu.unlam.mobile.scaffold.domain.models.track

data class Track(
    val spotifyId: String,
    val title: String,
    val artist: String,
    val image: String,
    val srcSpotify: String = "",
)
