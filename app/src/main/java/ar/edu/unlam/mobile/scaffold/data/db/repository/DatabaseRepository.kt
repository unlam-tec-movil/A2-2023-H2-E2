package ar.edu.unlam.mobile.scaffold.data.db.repository

import ar.edu.unlam.mobile.scaffold.data.db.database.AppDatabase

interface DatabaseRepository {
    suspend fun getDatabase(): AppDatabase
}
