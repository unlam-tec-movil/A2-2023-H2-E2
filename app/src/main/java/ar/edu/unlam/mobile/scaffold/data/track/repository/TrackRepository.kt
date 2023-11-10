package ar.edu.unlam.mobile.scaffold.data.track.repository

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface TrackRepository {
    suspend fun getTrendingTracks(): Flow<List<Track>>
}
