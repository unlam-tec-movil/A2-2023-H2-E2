package ar.edu.unlam.mobile.scaffold.data.authorization.network

import ar.edu.unlam.mobile.scaffold.domain.authorization.models.Authorization
import com.google.gson.annotations.SerializedName

data class AuthorizationAPIModel(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Long,
) {
    fun toAuthorization(): Authorization {
        return Authorization(
            accessToken = accessToken,
            tokenType = tokenType,
            expiresIn = expiresIn,
        )
    }
}
