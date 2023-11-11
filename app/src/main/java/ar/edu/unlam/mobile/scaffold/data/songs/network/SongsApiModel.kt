package ar.edu.unlam.mobile.scaffold.data.songs.network

import ar.edu.unlam.mobile.scaffold.data.playlist.models.PlaylistDTO
import ar.edu.unlam.mobile.scaffold.data.songs.models.AlbumsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.ArtistsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.Audiobooks
import ar.edu.unlam.mobile.scaffold.data.songs.models.EpisodesApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.ShowsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.models.TracksApiModel
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track

data class SongsApiModel(
    val tracks: TracksApiModel,
    val artistsApiModel: ArtistsApiModel,
    val albumsApiModel: AlbumsApiModel,
    val playlistsApiModel: PlaylistDTO,
    val showsApiModel: ShowsApiModel,
    val episodesApiModel: EpisodesApiModel,
    val audiobooks: Audiobooks,
) {
    /*    fun toTrack(): Track {
            val nameArtist: String = tracks.items[0].artists[0].name
            val imageSrc: String = tracks.items[0].album.images[0].url
            val titleTrack: String = tracks.items[0].name

            return Track(
                title = titleTrack,
                artist = nameArtist,
                image = imageSrc,
                srcSpotify = srcSpotify
            )
        }*/

    fun toTrackList(): List<Track> {
        val trackList: MutableList<Track> = mutableListOf()

        tracks.items.forEach {
            trackList.add(it.toTrack())
        }

        return trackList
    }
}
