package ar.edu.unlam.mobile.scaffold.data.db.entity

import androidx.room.Entity

@Entity(primaryKeys = ["playlistId", "spotifyId"])
data class PlaylistTrackCrossRef(
    val playlistId: Long,
    val spotifyId: String,
)
