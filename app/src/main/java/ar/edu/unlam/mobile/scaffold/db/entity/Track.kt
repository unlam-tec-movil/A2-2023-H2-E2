package ar.edu.unlam.mobile.scaffold.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Track(
    @PrimaryKey(autoGenerate = false) val spotifyId: Long,
    val title: String,
    val artist: String,
    val image: String,
)
