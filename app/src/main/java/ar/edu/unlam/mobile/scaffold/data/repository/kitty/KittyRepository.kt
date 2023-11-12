package ar.edu.unlam.mobile.scaffold.data.repository.kitty

import ar.edu.unlam.mobile.scaffold.domain.models.kitty.Kitty
import kotlinx.coroutines.flow.Flow

interface KittyRepository {
    suspend fun getKitty(): Flow<Kitty>
}
