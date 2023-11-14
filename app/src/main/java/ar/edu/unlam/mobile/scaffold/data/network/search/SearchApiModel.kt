package ar.edu.unlam.mobile.scaffold.data.network.search

import ar.edu.unlam.mobile.scaffold.data.apimodels.PlaylistDTO
import ar.edu.unlam.mobile.scaffold.data.apimodels.search.AlbumsApiModel
import ar.edu.unlam.mobile.scaffold.data.apimodels.search.ArtistsApiModel
import ar.edu.unlam.mobile.scaffold.data.apimodels.search.Audiobooks
import ar.edu.unlam.mobile.scaffold.data.apimodels.search.EpisodesApiModel
import ar.edu.unlam.mobile.scaffold.data.apimodels.search.ShowsApiModel
import ar.edu.unlam.mobile.scaffold.data.apimodels.search.TracksApiModel
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track

data class SearchApiModel(
    val tracks: TracksApiModel,
    val artistsApiModel: ArtistsApiModel,
    val albumsApiModel: AlbumsApiModel,
    val playlistsApiModel: PlaylistDTO,
    val showsApiModel: ShowsApiModel,
    val episodesApiModel: EpisodesApiModel,
    val audiobooks: Audiobooks,
) {
    fun toTrackList(): List<Track> {
        val trackList: MutableList<Track> = mutableListOf()

        tracks.items.forEach { trackApiModel ->
            trackList.add(trackApiModel.toTrack())
        }

        return trackList
    }
}
