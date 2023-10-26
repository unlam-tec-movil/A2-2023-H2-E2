package ar.edu.unlam.mobile.scaffold.data.playlist.repository

import ar.edu.unlam.mobile.scaffold.data.playlist.models.PlaylistDTO
import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsApiModel
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {
    suspend fun getSearchResults(query: String, accessToken: String): Flow<SongsApiModel>

    suspend fun getTrendingPlaylist(): Flow<PlaylistDTO>
}
