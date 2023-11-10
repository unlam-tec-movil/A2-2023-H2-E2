package ar.edu.unlam.mobile.scaffold.data.authorization.network

import ar.edu.unlam.mobile.scaffold.domain.authorization.models.Authorization
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthorizationAPI {

    @FormUrlEncoded
    @POST("/api/token")
    suspend fun getAuthorization(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
    ): Authorization
}
