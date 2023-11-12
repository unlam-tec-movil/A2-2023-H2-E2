package ar.edu.unlam.mobile.scaffold.domain.services.authorization

import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
import kotlinx.coroutines.flow.Flow

interface AuthorizationGetter {
    suspend fun getAuthorization(
        grantType: String,
        clientId: String,
        clientSecret: String,
    ): Flow<Authorization>
}
