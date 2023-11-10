package ar.edu.unlam.mobile.scaffold.data.songs.network

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface SongsNetworkRepository {

    suspend fun getSearchValues(query: String): Flow<List<Track>>
}
