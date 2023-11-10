package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import kotlinx.coroutines.flow.Flow

interface TrackNetworkRepository {
    suspend fun getTrendingTracks(): Flow<Trend>
}
