package ar.edu.unlam.mobile.scaffold.data.db.entity

import androidx.room.Embedded
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
)
