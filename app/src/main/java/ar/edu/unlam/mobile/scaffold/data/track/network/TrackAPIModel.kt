package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track

data class TrackAPIModel(
    val title: String,
    val artist: String,
    val image: String
) {
    fun toTrack(): Track {
        return Track(
            title = title,
            artist = artist,
            image = image
        )
    }
}