package ar.edu.unlam.mobile.scaffold.data.repository.search

import ar.edu.unlam.mobile.scaffold.data.network.search.SearchNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchAPIRepository @Inject constructor(
    private val networkRepository: SearchNetworkRepository,
) :
    SearchRepository {
    override suspend fun getSearchResults(
        query: String,
    ): Flow<List<Track>> {
        return this.networkRepository.getSearchValues(query = query)
    }
}
