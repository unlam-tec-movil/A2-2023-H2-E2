package ar.edu.unlam.mobile.scaffold.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Track(
    @PrimaryKey(autoGenerate = false) val spotifyId: String,
    val title: String,
    val artist: String,
    val image: String,
)
