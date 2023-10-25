package ar.edu.unlam.mobile.scaffold.data.songs.repository

import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsApiModel
import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    suspend fun getSearchResults(query: String, accessToken: String): Flow<SongsApiModel>
}
