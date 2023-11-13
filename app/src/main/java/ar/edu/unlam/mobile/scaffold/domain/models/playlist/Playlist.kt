package ar.edu.unlam.mobile.scaffold.domain.models.playlist

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

data class Playlist(
    val id: Long,
    val title: String,
    val image: String,
    val tracks: List<Track>,
)
