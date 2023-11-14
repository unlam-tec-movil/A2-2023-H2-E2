package ar.edu.unlam.mobile.scaffold.data.repository.authorization

import ar.edu.unlam.mobile.scaffold.data.network.authorization.AuthorizationNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthorizationDefaultRepository
@Inject constructor(val networkRepo: AuthorizationNetworkRepository) : AuthorizationRepository {
    override suspend fun getAuthorization(): Flow<Authorization> {
        return networkRepo.getAuthorization()
    }
}
