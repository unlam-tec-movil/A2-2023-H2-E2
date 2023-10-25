package ar.edu.unlam.mobile.scaffold.data.authorization.models

import com.google.gson.annotations.SerializedName

data class AuthorizationResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("token_type") val tokenType: String,
    @SerializedName("expires_in") val expiresInMilliseconds: Int,
)
