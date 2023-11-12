package ar.edu.unlam.mobile.scaffold.domain.models.authorization

data class Authorization(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Long,
)
