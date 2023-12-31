package ar.edu.unlam.mobile.scaffold.data.network.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.Recommendation
import ar.edu.unlam.mobile.scaffold.data.apimodels.track.Track
import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrackHTTPRepository @Inject constructor(private val api: TrackAPI) : TrackNetworkRepository {
    override suspend fun getRecommendations(genres: String): Flow<Recommendation> {
        return flow {
            emit(
                api.getRecommendations(
                    5,
                    "AR",
                    genres,
                    60,
                    100,
                ),
            )
        }
    }

    override suspend fun getTrendingTracks(): Flow<Trend> {
        return flow {
            emit(
                api.getTrendingTracks(
                    "AR",
                    "tracks.items(track(id,name,artists.name,album.images))",
                ),
            )
        }
    }

    override suspend fun getAPITrack(id: String): Flow<Track> {
        return flow {
            emit(
                api.getTrack(id, "AR"),
            )
        }
    }
}
