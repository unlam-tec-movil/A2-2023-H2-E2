package ar.edu.unlam.mobile.scaffold.data.network.search

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface SearchNetworkRepository {

    suspend fun getSearchValues(query: String): Flow<List<Track>>
}
