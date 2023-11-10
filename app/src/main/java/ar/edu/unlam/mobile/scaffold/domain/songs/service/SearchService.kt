package ar.edu.unlam.mobile.scaffold.domain.songs.service

import ar.edu.unlam.mobile.scaffold.data.songs.repository.SongsRepository
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchService @Inject constructor(private val repository: SongsRepository) : SearchGetter {
    override suspend fun getSearchResults(
        query: String
    ): Flow<List<Track>> {
        return this.repository.getSearchResults(query = query)
    }
}
