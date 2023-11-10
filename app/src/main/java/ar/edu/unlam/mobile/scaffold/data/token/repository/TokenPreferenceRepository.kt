package ar.edu.unlam.mobile.scaffold.data.token.repository

interface TokenPreferenceRepository {
    suspend fun setToken(key: String, value: String)
    suspend fun getToken(key: String): String?
}