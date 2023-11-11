package ar.edu.unlam.mobile.scaffold.domain.authorization.services

import ar.edu.unlam.mobile.scaffold.domain.authorization.models.Authorization
import kotlinx.coroutines.flow.Flow

interface AuthorizationGetter {
    suspend fun getAuthorization(
        grantType: String,
        clientId: String,
        clientSecret: String,
    ): Flow<Authorization>
}
