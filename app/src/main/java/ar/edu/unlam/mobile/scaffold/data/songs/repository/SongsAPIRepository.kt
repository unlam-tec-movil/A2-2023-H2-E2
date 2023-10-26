package ar.edu.unlam.mobile.scaffold.data.songs.repository

import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsApiModel
import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsNetworkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongsAPIRepository @Inject constructor(
    private val networkRepository: SongsNetworkRepository,
) :
    SongsRepository {
    override suspend fun getSearchResults(
        query: String,
        accessToken: String,
    ): Flow<SongsApiModel> {
        return this.networkRepository.getSearchValues(query = query, accessToken = accessToken)
    }
}
