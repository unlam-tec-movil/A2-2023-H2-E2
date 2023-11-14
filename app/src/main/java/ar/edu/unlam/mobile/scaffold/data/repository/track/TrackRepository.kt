package ar.edu.unlam.mobile.scaffold.data.repository.track

import ar.edu.unlam.mobile.scaffold.domain.models.track.FullTrack
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow

interface TrackRepository {
    suspend fun getRecommendations(genres: String): Flow<List<Track>>
    suspend fun getTrendingTracks(): Flow<List<Track>>
    suspend fun getAPITrack(id: String): Flow<FullTrack>
}
