package ar.edu.unlam.mobile.scaffold.domain.playlist.models

import ar.edu.unlam.mobile.scaffold.data.playlist.models.PlaylistDTO
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song

data class Playlist(
    val id: Long,
    val title: String,
    val image: String,
    val songs: List<Song>,
)
// Todo, mapear https://developer.spotify.com/documentation/web-api/reference/get-playlists-tracks

fun PlaylistDTO.asModel() = Playlist(
    id = 1,
    title = "title",
    image = "imagen",
    songs = listOf(),
)
