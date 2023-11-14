package ar.edu.unlam.mobile.scaffold.domain.models.playlist

import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistWithTracks
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

data class Playlist(
    val id: Long? = null,
    val title: String,
    val image: String = "",
    val description: String = "",
    val tracks: List<Track> = emptyList(),
) {
    fun toPlaylistEntity(): ar.edu.unlam.mobile.scaffold.data.database.entity.Playlist {
        return ar.edu.unlam.mobile.scaffold.data.database.entity
            .Playlist(playlistId = this.id?:0 ,name = this.title, description = this.description, image = this.image)
    }
}

fun PlaylistWithTracks.toDomainPlaylist() =
    Playlist(
        id = playlist.playlistId,
        title = playlist.name,
        description = playlist.description,
        image = playlist.image,
        tracks = tracks.map { it.toDomainTrack() },
    )
