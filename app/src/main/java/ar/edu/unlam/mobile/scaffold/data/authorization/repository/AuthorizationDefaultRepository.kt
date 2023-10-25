package ar.edu.unlam.mobile.scaffold.data.authorization.repository

import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse
import ar.edu.unlam.mobile.scaffold.data.authorization.network.AuthorizationNetworkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthorizationDefaultRepository
@Inject constructor(val networkRepo: AuthorizationNetworkRepository) : AuthorizationRepository {
    override suspend fun getAuthorization(): Flow<AuthorizationResponse> {
        return networkRepo.getAuthorization()
    }
}
