package ar.edu.unlam.mobile.scaffold.domain.search.service

import ar.edu.unlam.mobile.scaffold.data.search.network.SearchApiModel
import ar.edu.unlam.mobile.scaffold.data.search.repository.SearchRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchService @Inject constructor(private val repository: SearchRepository) : SearchGetter {
    override suspend fun getSearchResults(
        query: String,
        accessToken: String
    ): Flow<SearchApiModel> {
        return this.repository.getSearchResults(query = query, accessToken = accessToken)
    }
}
