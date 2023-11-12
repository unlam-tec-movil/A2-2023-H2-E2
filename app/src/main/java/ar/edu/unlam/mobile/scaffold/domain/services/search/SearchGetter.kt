package ar.edu.unlam.mobile.scaffold.domain.services.search

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface SearchGetter {
    suspend fun getSearchResults(query: String): Flow<List<Track>>
}
