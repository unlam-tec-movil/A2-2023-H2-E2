package ar.edu.unlam.mobile.scaffold.data.network.search

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchHTTPRepository
@Inject constructor(
    private val searchAPI: SearchAPI,
) : SearchNetworkRepository {
    override suspend fun getSearchValues(query: String): Flow<List<Track>> {
        return flow {
            emit(searchAPI.search(query = query).toTrackList())
        }
    }
}
