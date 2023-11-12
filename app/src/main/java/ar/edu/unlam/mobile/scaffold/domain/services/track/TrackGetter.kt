package ar.edu.unlam.mobile.scaffold.domain.services.track

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface TrackGetter {
    suspend fun getRecommendations(): Flow<List<Track>>
    suspend fun getTrackById(id: Int): Flow<Track>
    suspend fun getTrendingTracks(): Flow<List<Track>>
}
