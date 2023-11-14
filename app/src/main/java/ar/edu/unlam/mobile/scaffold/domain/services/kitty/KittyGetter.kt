package ar.edu.unlam.mobile.scaffold.domain.services.kitty

import ar.edu.unlam.mobile.scaffold.domain.models.kitty.Kitty
import kotlinx.coroutines.flow.Flow

interface KittyGetter {
    suspend fun getKitty(): Flow<Kitty>
    suspend fun getKittyById(id: Int): Flow<Kitty>
}
