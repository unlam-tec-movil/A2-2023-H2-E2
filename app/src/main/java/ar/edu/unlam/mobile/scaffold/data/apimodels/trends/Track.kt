package ar.edu.unlam.mobile.scaffold.data.apimodels.trends

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

data class Track(
    val id: String,
    val album: Album,
    val artists: List<Artist>,
    val name: String,
) {
    fun toTrack(): Track {
        return Track(
            title = name,
            artist = artists[0].name,
            image = album.images[1].url,
            spotifyId = id,
        )
    }
}
