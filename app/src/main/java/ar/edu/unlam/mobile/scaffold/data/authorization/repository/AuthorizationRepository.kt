package ar.edu.unlam.mobile.scaffold.data.authorization.repository

import ar.edu.unlam.mobile.scaffold.data.authorization.models.AuthorizationResponse
import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {

    suspend fun getAuthorization(): Flow<AuthorizationResponse>
}
