package ar.edu.unlam.mobile.scaffold.data.songs.repository

import ar.edu.unlam.mobile.scaffold.data.songs.network.SongsNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongsAPIRepository @Inject constructor(
    private val networkRepository: SongsNetworkRepository,
) :
    SongsRepository {
    override suspend fun getSearchResults(
        query: String
    ): Flow<List<Track>> {
        return this.networkRepository.getSearchValues(query = query)
    }
}
