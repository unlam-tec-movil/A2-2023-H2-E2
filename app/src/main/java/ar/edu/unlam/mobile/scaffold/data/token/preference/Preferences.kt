package ar.edu.unlam.mobile.scaffold.data.token.preference

interface Preferences {
    suspend fun setToken(key: String, value: String)
    suspend fun getToken(key: String): String?
}
