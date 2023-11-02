package ar.edu.unlam.mobile.scaffold.domain.track.services

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface TrackGetter {
    suspend fun getTrack(): Flow<Track>
    suspend fun getTrackById(id: Int): Flow<Track>
}