package ar.edu.unlam.mobile.scaffold.data.network.authorization

import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
import ar.edu.unlam.mobile.scaffold.utils.constants.AuthorizationConstants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthorizationHTTPRepository @Inject constructor(private val api: AuthorizationAPI) :
    AuthorizationNetworkRepository {
    override suspend fun getAuthorization(): Flow<Authorization> {
        return flow {
            emit(
                api.getAuthorization(
                    AuthorizationConstants.CLIENT_CREDENTIALS,
                    AuthorizationConstants.CLIENT_ID,
                    AuthorizationConstants.CLIENT_SECRET,
                ),
            )
        }
    }
}
