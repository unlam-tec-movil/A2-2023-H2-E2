package ar.edu.unlam.mobile.scaffold.domain.songs.service

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface SearchGetter {
    suspend fun getSearchResults(query: String): Flow<List<Track>>
}
