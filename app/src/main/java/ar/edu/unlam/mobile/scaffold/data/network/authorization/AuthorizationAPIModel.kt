package ar.edu.unlam.mobile.scaffold.data.network.authorization

import ar.edu.unlam.mobile.scaffold.domain.models.authorization.Authorization
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
