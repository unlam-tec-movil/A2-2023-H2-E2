package ar.edu.unlam.mobile.scaffold.data.track.network

import kotlinx.coroutines.flow.Flow

interface TrackNetworkRepository {
    suspend fun getRandomTrack(): Flow<TrackAPIModel>
}