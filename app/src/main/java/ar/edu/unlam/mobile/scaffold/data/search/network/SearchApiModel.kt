package ar.edu.unlam.mobile.scaffold.data.search.network

import ar.edu.unlam.mobile.scaffold.data.search.objects.albums.AlbumsApiModel
import ar.edu.unlam.mobile.scaffold.data.search.objects.artists.ArtistsApiModel
import ar.edu.unlam.mobile.scaffold.data.search.objects.audiobooks.Audiobooks
import ar.edu.unlam.mobile.scaffold.data.search.objects.episodes.EpisodesApiModel
import ar.edu.unlam.mobile.scaffold.data.search.objects.playlists.PlaylistsApiModel
import ar.edu.unlam.mobile.scaffold.data.search.objects.shows.ShowsApiModel
import ar.edu.unlam.mobile.scaffold.data.search.objects.tracks.TracksApiModel

data class SearchApiModel(
    val tracks: TracksApiModel,
    val artistsApiModel: ArtistsApiModel,
    val albumsApiModel: AlbumsApiModel,
    val playlistsApiModel: PlaylistsApiModel,
    val showsApiModel: ShowsApiModel,
    val episodesApiModel: EpisodesApiModel,
    val audiobooks: Audiobooks,
)
