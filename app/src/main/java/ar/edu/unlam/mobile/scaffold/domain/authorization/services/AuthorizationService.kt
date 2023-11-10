package ar.edu.unlam.mobile.scaffold.domain.authorization.services

import ar.edu.unlam.mobile.scaffold.data.authorization.repository.AuthorizationRepository
import ar.edu.unlam.mobile.scaffold.domain.authorization.models.Authorization
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthorizationService @Inject constructor(val repository: AuthorizationRepository) :
    AuthorizationGetter {
    override suspend fun getAuthorization(
        grantType: String,
        clientId: String,
        clientSecret: String
    ): Flow<Authorization> {
        return this.repository.getAuthorization()
    }
}
