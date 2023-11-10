package ar.edu.unlam.mobile.scaffold.data.token.repository

import ar.edu.unlam.mobile.scaffold.data.token.preference.Preferences
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val preferences: Preferences
) : TokenPreferenceRepository {
    override suspend fun setToken(key: String, value: String) {
        preferences.setToken(key, value)
    }

    override suspend fun getToken(key: String): String? {
        return preferences.getToken(key)
    }
}