package ar.edu.unlam.mobile.scaffold.domain.search.service


import ar.edu.unlam.mobile.scaffold.data.search.network.SearchApiModel
import kotlinx.coroutines.flow.Flow

interface SearchGetter {

     suspend fun getSearchResults(query: String, accessToken: String): Flow<SearchApiModel>

 }
