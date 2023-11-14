package ar.edu.unlam.mobile.scaffold.data.database.repository

import ar.edu.unlam.mobile.scaffold.data.database.AppDatabase

interface DatabaseRepository {
    suspend fun getDatabase(): AppDatabase
}
