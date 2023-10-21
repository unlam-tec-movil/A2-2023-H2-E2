package ar.edu.unlam.mobile.scaffold.data.search.network

import kotlinx.coroutines.flow.Flow

interface SearchNetworkRepository {

    suspend fun getSearchValues(query: String, accessToken: String): Flow<SearchApiModel>
}
