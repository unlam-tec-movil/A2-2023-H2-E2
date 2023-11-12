package ar.edu.unlam.mobile.scaffold.domain.track.services

import ar.edu.unlam.mobile.scaffold.data.track.repository.TrackRepository
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrackService @Inject constructor(val repository: TrackRepository) : TrackGetter {
    override suspend fun getRecommendations(): Flow<List<Track>> {
        return this.repository.getRecommendations()
    }

    override suspend fun getTrackById(id: String): Flow<Track> {
        return this.repository.getSimpleTrack(trackId = id)
    }

    override suspend fun getTrendingTracks(): Flow<List<Track>> {
        return this.repository.getTrendingTracks()
    }
}
