package ar.edu.unlam.mobile.scaffold.data.track.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrackHTTPRepository @Inject constructor(private val api: TrackAPI) : TrackNetworkRepository {
    override suspend fun getRandomTrack(): Flow<TrackAPIModel> {
        return flow {
            emit(api.getTrackRecommendations()[0])
        }
    }
}