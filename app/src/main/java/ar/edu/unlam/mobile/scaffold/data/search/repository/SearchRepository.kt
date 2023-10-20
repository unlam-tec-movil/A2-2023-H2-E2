package ar.edu.unlam.mobile.scaffold.data.search.repository

import ar.edu.unlam.mobile.scaffold.data.search.network.SearchApiModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchResults(query: String, accessToken: String) : Flow<SearchApiModel>
}