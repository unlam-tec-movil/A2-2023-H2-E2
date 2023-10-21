package ar.edu.unlam.mobile.scaffold.data.search.repository

import ar.edu.unlam.mobile.scaffold.data.search.network.SearchApiModel
import ar.edu.unlam.mobile.scaffold.data.search.network.SearchNetworkRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class SearchAPIRepository @Inject constructor(
    private val networkRepository: SearchNetworkRepository
) :
    SearchRepository {
    override suspend fun getSearchResults(
        query: String,
        accessToken: String
    ): Flow<SearchApiModel> {
        return this.networkRepository.getSearchValues(query = query, accessToken = accessToken)
    }
}
