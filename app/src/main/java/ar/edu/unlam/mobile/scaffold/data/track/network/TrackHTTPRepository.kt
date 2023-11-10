package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrackHTTPRepository @Inject constructor(private val api: TrackAPI) : TrackNetworkRepository {
    override suspend fun getTrendingTracks(): Flow<Trend> {
        return flow {
            emit(api.getTrendingTracks("AR", "tracks.items(track(name,artists.name,album.images))"))
        }
    }
}
