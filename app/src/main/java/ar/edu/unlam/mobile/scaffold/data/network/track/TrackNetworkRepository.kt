package ar.edu.unlam.mobile.scaffold.data.network.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.Recommendation
import ar.edu.unlam.mobile.scaffold.data.apimodels.track.Track
import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import kotlinx.coroutines.flow.Flow

interface TrackNetworkRepository {
    suspend fun getRecommendations(genres: String): Flow<Recommendation>
    suspend fun getTrendingTracks(): Flow<Trend>
    suspend fun getAPITrack(id: String): Flow<Track>
}
