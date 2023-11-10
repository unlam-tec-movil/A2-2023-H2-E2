package ar.edu.unlam.mobile.scaffold.data.authorization.network

import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse
import ar.edu.unlam.mobile.scaffold.utils.constants.CLIENT_CREDENTIALS
import ar.edu.unlam.mobile.scaffold.utils.constants.CLIENT_ID
import ar.edu.unlam.mobile.scaffold.utils.constants.CLIENT_SECRET
import javax.inject.Inject

class AuthorizationHTTPRepotistory
@Inject constructor(private val authorizationAPI: AuthorizationAPI) :
    AuthorizationNetworkRepository {
    override suspend fun getAuthorization(): AuthorizationResponse? {
        return this.authorizationAPI.getAuthorization(
            grantType = CLIENT_CREDENTIALS,
            clientId = CLIENT_ID,
            clientSecret = CLIENT_SECRET
        ).body()
    }
}
