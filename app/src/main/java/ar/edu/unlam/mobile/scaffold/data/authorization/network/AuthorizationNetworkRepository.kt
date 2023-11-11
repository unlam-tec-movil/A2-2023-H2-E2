package ar.edu.unlam.mobile.scaffold.data.authorization.network

import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse

interface AuthorizationNetworkRepository {

    suspend fun getAuthorization(): AuthorizationResponse?
}
