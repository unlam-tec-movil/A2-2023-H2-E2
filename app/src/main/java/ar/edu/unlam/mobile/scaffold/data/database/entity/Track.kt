package ar.edu.unlam.mobile.scaffold.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Track(
    @PrimaryKey(autoGenerate = false) val spotifyId: String,
    val title: String,
    val artist: String,
    val image: String,
) {
    fun toDomainTrack(): ar.edu.unlam.mobile.scaffold.domain.models.track.Track {
        return ar.edu.unlam.mobile.scaffold.domain.models.track.Track(
            spotifyId = spotifyId,
            title = title,
            artist = artist,
            image = image,
        )
    }
}
