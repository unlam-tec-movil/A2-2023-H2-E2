package ar.edu.unlam.mobile.scaffold.domain.models.track

data class Track(
    val spotifyId: String,
    val title: String,
    val artist: String,
    val image: String,
    val srcSpotify: String = "",
) {
    fun toTrackEntity(): ar.edu.unlam.mobile.scaffold.data.database.entity.Track {
        return ar.edu.unlam.mobile.scaffold.data.database.entity.Track(
            spotifyId = spotifyId,
            title = title,
            artist = artist,
            image = image,
        )
    }
}
