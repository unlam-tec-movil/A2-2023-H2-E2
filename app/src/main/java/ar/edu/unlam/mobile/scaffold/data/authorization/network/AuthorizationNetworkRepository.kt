package ar.edu.unlam.mobile.scaffold.data.authorization.network

import ar.edu.unlam.mobile.scaffold.domain.authorization.models.Authorization
import kotlinx.coroutines.flow.Flow

interface AuthorizationNetworkRepository {
    suspend fun getAuthorization(): Flow<Authorization>
}
