package ar.edu.unlam.mobile.scaffold.data.songs.network

import kotlinx.coroutines.flow.Flow

interface SongsNetworkRepository {

    suspend fun getSearchValues(query: String, accessToken: String): Flow<SongsApiModel>
}
