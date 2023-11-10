package ar.edu.unlam.mobile.scaffold.data.songs.repository


import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    suspend fun getSearchResults(query: String): Flow<List<Track>>
}
