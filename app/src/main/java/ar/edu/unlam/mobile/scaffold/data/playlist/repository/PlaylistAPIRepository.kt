package ar.edu.unlam.mobile.scaffold.data.playlist.repository

import ar.edu.unlam.mobile.scaffold.data.playlist.models.PlaylistDTO
import ar.edu.unlam.mobile.scaffold.data.playlist.network.PlaylistNetworkRepository
import ar.edu.unlam.mobile.scaffold.data.playlist.network.toDTO
import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsApiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistAPIRepository @Inject constructor(
    private val networkRepository: PlaylistNetworkRepository,
) :
    PlaylistRepository {
    override suspend fun getSearchResults(
        query: String,
        accessToken: String,
    ): Flow<SongsApiModel> {
        TODO()
    }

    override suspend fun getTrendingPlaylist(): Flow<PlaylistDTO> {
        return flow {
            networkRepository.getById("3cEYpjA9oz9GiPac4AsH4n")
                .collect { playlist ->
                    emit(playlist.toDTO())
                }
        }
    }
}
