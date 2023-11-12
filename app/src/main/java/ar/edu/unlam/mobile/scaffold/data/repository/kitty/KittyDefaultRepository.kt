package ar.edu.unlam.mobile.scaffold.data.repository.kitty

import ar.edu.unlam.mobile.scaffold.data.network.kitty.KittyNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.models.kitty.Kitty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class KittyDefaultRepository @Inject constructor(val networkRepository: KittyNetworkRepository) :
    KittyRepository {
    override suspend fun getKitty(): Flow<Kitty> {
        return this.networkRepository.getRandomKitty().map { it.toKitty() }
    }
}
