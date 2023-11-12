package ar.edu.unlam.mobile.scaffold.domain.services.search

import ar.edu.unlam.mobile.scaffold.data.repository.search.SearchRepository
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchService @Inject constructor(private val repository: SearchRepository) : SearchGetter {
    override suspend fun getSearchResults(
        query: String,
    ): Flow<List<Track>> {
        return this.repository.getSearchResults(query = query)
    }
}
