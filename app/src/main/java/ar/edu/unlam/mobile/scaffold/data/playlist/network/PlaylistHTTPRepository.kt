package ar.edu.unlam.mobile.scaffold.data.playlist.network

import ar.edu.unlam.mobile.scaffold.data.authorization.repository.AuthorizationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistHTTPRepository @Inject constructor(
    private val authRepo: AuthorizationRepository,
    private val playlistAPI: PlaylistAPI,
) : PlaylistNetworkRepository {
    override suspend fun getSearchValues(query: String, accessToken: String): Flow<PlaylistApiModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: String): Flow<PlaylistApiModel> {
        return flow {
            authRepo.getAuthorization().collect { token ->
                playlistAPI.getById(id = id, accessToken = token.accessToken)
                    .collect { playlist ->
                        emit(playlist)
                    }
            }
        }
    }
}
