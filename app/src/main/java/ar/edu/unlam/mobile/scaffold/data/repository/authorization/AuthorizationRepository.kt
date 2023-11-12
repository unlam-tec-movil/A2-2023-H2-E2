package ar.edu.unlam.mobile.scaffold.data.repository.authorization

import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {
    suspend fun getAuthorization(): Flow<Authorization>
}
