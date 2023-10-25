package ar.edu.unlam.mobile.scaffold.data.authorization.network

import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse
import kotlinx.coroutines.flow.Flow

interface AuthorizationNetworkRepository {
    suspend fun getAuthorization(): Flow<AuthorizationResponse>
}
