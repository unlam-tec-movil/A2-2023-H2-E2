package ar.edu.unlam.mobile.scaffold.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true) val playlistId: Long,
    val name: String,
    val description: String,
    val image: String,
)
