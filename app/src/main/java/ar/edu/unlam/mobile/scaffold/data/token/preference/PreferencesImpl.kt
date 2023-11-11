package ar.edu.unlam.mobile.scaffold.data.token.preference

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import javax.inject.Inject

private const val APP_DATA_STORE = "appDataStore"

private val Context.dataStore by preferencesDataStore(name = APP_DATA_STORE)

class PreferencesImpl @Inject constructor(
    private val context: Context,
) : Preferences {
    override suspend fun setToken(key: String, value: String) {
        val preferenceKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences -> preferences[preferenceKey] = value }
    }

    override suspend fun getToken(key: String): String? {
        return try {
            val preferenceKey = stringPreferencesKey(key)
            val preferences = context.dataStore.data.first()
            preferences[preferenceKey]
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
