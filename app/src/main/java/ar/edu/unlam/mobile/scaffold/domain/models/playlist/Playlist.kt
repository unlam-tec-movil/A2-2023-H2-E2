package ar.edu.unlam.mobile.scaffold.domain.models.playlist

import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistTrackCrossRef
import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistWithTracks
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

data class Playlist(
    val id: Long,
    val title: String,
    val image: String,
    val description: String = "",
    val tracks: List<Track>,
) {
    fun toPlaylistEntity(): ar.edu.unlam.mobile.scaffold.data.database.entity.Playlist {
        return ar.edu.unlam.mobile.scaffold.data.database.entity
            .Playlist(name = this.title, description = this.description, image = this.image)
    }

    fun toPlaylistTrackCrossRef(): PlaylistTrackCrossRef {
        return PlaylistTrackCrossRef(playlistId = this.id, spotifyId = this.tracks[0].spotifyId)
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
