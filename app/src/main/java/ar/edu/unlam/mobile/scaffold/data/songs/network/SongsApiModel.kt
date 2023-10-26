package ar.edu.unlam.mobile.scaffold.data.songs.network

import ar.edu.unlam.mobile.scaffold.data.playlist.models.PlaylistDTO
import ar.edu.unlam.mobile.scaffold.data.songs.models.AlbumsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.ArtistsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.Audiobooks
import ar.edu.unlam.mobile.scaffold.data.songs.models.EpisodesApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.ShowsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.TracksApiModel

data class SongsApiModel(
    val tracks: TracksApiModel,
    val artistsApiModel: ArtistsApiModel,
    val albumsApiModel: AlbumsApiModel,
    val playlistsApiModel: PlaylistDTO,
    val showsApiModel: ShowsApiModel,
    val episodesApiModel: EpisodesApiModel,
    val audiobooks: Audiobooks,
)
