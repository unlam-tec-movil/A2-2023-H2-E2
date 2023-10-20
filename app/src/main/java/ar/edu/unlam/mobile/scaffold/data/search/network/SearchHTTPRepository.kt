package ar.edu.unlam.mobile.scaffold.data.search.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchHTTPRepository @Inject constructor(private val searchAPI: SearchAPI) : SearchNetworkRepository {
    override suspend fun getSearchValues(query: String, accessToken: String): Flow<SearchApiModel> {
        return flow {
            emit(searchAPI.search(query = query, auth = accessToken))
        }
    }


}