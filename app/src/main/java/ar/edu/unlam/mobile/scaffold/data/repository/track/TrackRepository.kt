package ar.edu.unlam.mobile.scaffold.data.repository.track

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface TrackRepository {
    suspend fun getRecommendations(): Flow<List<Track>>
    suspend fun getTrendingTracks(): Flow<List<Track>>
}
