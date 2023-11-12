package ar.edu.unlam.mobile.scaffold.domain.services.authorization

import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationMockService @Inject constructor() : AuthorizationGetter {
    override suspend fun getAuthorization(
        grantType: String,
        clientId: String,
        clientSecret: String,
    ): Flow<Authorization> {
        return flow {
            emit(
                Authorization("", "", 3600L),
            )
        }
    }
}
