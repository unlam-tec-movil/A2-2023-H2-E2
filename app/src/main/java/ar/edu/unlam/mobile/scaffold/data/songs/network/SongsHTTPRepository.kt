package ar.edu.unlam.mobile.scaffold.data.songs.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SongsHTTPRepository @Inject constructor(private val searchAPI: SongsAPI) : SongsNetworkRepository {
    override suspend fun getSearchValues(query: String, accessToken: String): Flow<SongsApiModel> {
        return flow {
            emit(searchAPI.search(query = query, auth = accessToken))
        }
    }
}
