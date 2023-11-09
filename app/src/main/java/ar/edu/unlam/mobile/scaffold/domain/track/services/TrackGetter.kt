package ar.edu.unlam.mobile.scaffold.domain.track.services

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface TrackGetter {
    suspend fun getTrackById(id: Int): Flow<Track>
    suspend fun getTrendingTracks(): Flow<List<Track>>
}
