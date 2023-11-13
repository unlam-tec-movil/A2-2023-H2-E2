package ar.edu.unlam.mobile.scaffold.domain.models.playlist

import ar.edu.unlam.mobile.scaffold.data.database.entity.PlaylistWithTracks
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

data class Playlist(
    val id: Long,
    val title: String,
    val image: String,
    val description: String = "",
    val tracks: List<Track>,
)

fun PlaylistWithTracks.toDomainPlaylist() =
    Playlist(
        id = playlist.playlistId,
        title = playlist.name,
        image = playlist.image,
        description = playlist.description,
        tracks = tracks.map { it.toDomainTrack() },
    )
