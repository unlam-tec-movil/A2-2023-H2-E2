package ar.edu.unlam.mobile.scaffold.data.network.authorization

import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
import kotlinx.coroutines.flow.Flow

interface AuthorizationNetworkRepository {
    suspend fun getAuthorization(): Flow<Authorization>
}
