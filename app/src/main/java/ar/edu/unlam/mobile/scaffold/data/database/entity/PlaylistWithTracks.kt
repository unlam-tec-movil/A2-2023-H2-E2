package ar.edu.unlam.mobile.scaffold.data.database.entity

import  androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation

@Entity
data class PlaylistWithTracks(
    @Embedded val playlist: Playlist,
    @Relation(
        parentColumn = "playlistId",
        entityColumn = "spotifyId",
        associateBy = Junction(PlaylistTrackCrossRef::class),
    )
    val tracks: List<Track>,
) {
    fun toDomainPlaylist(): ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist {
        return ar.edu.unlam.mobile.scaffold.domain.models.playlist.Playlist(
            id = playlist.playlistId,
            title = playlist.name,
            image = playlist.image,
            tracks = tracks.map { it.toDomainTrack() }
        )
    }
}
