package ar.edu.unlam.mobile.scaffold.data.songs.network


import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SongsHTTPRepository
@Inject constructor(
    private val searchAPI: SongsAPI
) : SongsNetworkRepository {
    override suspend fun getSearchValues(query: String): Flow<List<Track>> {
        return flow {
            emit(searchAPI.search(query = query).toTrackList())//${authorization.accessToken}"))
        }
    }
}
