package ar.edu.unlam.mobile.scaffold.domain.models.track

data class FullTrack(
    val spotifyId: String,
    val title: String,
    val artists: List<Artist>,
    val album: String,
    val image: String,
    val releaseDate: String,
    val duration: Long,
)
