package ar.edu.unlam.mobile.scaffold.data.playlist.network

import kotlinx.coroutines.flow.Flow

interface PlaylistNetworkRepository {
    suspend fun getSearchValues(query: String, accessToken: String): Flow<PlaylistApiModel>

    suspend fun getById(id: String): Flow<PlaylistApiModel>
}
