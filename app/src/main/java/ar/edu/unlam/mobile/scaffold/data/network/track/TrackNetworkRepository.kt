package ar.edu.unlam.mobile.scaffold.data.network.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.Recommendation
import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import kotlinx.coroutines.flow.Flow

interface TrackNetworkRepository {
    suspend fun getRecommendations(): Flow<Recommendation>
    suspend fun getTrendingTracks(): Flow<Trend>
}