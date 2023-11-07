package ar.edu.unlam.mobile.scaffold.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Track(
    @PrimaryKey(autoGenerate = true) val trackId: Long,
    val title: String,
    val artist: String,
    val image: String,
)
