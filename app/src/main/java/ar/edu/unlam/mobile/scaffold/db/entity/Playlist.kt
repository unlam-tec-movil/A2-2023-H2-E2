package ar.edu.unlam.mobile.scaffold.db.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val description: String? = null,
    val image: Bitmap? = null,
    val creationDate: LocalDateTime,
    val modificationDate: LocalDateTime,
    val tracks: List<Track>,
)
