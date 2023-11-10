package ar.edu.unlam.mobile.scaffold.domain.authorization.models

data class Authorization(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Long,
)
