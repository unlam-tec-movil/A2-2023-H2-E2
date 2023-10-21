package ar.edu.unlam.mobile.scaffold.data.kitty.network

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class KittyHTTPRepository @Inject constructor(private val api: KittyAPI) : KittyNetworkRepository {
    override suspend fun getRandomKitty(): Flow<KittyAPIModel> {
        return flow {
            emit(api.getKitties()[0])
        }
    }
}
