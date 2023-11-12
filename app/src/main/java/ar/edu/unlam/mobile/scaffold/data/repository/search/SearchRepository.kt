package ar.edu.unlam.mobile.scaffold.data.repository.search

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getSearchResults(query: String): Flow<List<Track>>
}
