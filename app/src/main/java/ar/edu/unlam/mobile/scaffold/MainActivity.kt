package ar.edu.unlam.mobile.scaffold

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import ar.edu.unlam.mobile.scaffold.ui.screens.NavigationView
import ar.edu.unlam.mobile.scaffold.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token_api")

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    NavigationView()
                }
            }
        }
    }
}
