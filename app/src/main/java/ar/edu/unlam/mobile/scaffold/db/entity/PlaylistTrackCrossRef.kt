package ar.edu.unlam.mobile.scaffold.db.entity

import androidx.room.Entity

@Entity(primaryKeys = ["playlistId", "spotifyId"])
data class PlaylistTrackCrossRef(
    val playlistId: Long,
    val spotifyId: Long,
)
