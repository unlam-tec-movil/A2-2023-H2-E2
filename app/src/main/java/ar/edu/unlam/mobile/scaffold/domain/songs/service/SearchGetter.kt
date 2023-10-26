package ar.edu.unlam.mobile.scaffold.domain.songs.service

import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsApiModel
import kotlinx.coroutines.flow.Flow

interface SearchGetter {
    suspend fun getSearchResults(query: String, accessToken: String): Flow<SongsApiModel>
}
