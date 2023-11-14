package ar.edu.unlam.mobile.scaffold.domain.services.track

import ar.edu.unlam.mobile.scaffold.data.repository.track.TrackRepository
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrackService @Inject constructor(val repository: TrackRepository) : TrackGetter {
    override suspend fun getRecommendations(): Flow<List<Track>> {
        return this.repository.getRecommendations("")
    }

    override suspend fun getTrackById(id: Int): Flow<Track> {
        TODO("Not yet implemented")
    }

    override suspend fun getTrendingTracks(): Flow<List<Track>> {
        return this.repository.getTrendingTracks()
    }
}
