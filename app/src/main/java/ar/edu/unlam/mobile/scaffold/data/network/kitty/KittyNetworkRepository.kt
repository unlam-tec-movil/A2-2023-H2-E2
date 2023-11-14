package ar.edu.unlam.mobile.scaffold.data.network.kitty

import kotlinx.coroutines.flow.Flow

interface KittyNetworkRepository {
    suspend fun getRandomKitty(): Flow<KittyAPIModel>
}
