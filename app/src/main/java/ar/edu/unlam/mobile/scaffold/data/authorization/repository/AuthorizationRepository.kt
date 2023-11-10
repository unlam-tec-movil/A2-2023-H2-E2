package ar.edu.unlam.mobile.scaffold.data.authorization.repository

import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse

interface AuthorizationRepository {

    suspend fun getAuthorization(): AuthorizationResponse?
}
