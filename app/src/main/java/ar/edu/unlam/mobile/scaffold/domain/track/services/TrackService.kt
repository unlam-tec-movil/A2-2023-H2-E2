package ar.edu.unlam.mobile.scaffold.domain.track.services

import ar.edu.unlam.mobile.scaffold.data.track.repository.TrackRepository
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrackService @Inject constructor(val repository: TrackRepository) : TrackGetter {
    override suspend fun getTrack(): Flow<Track> {
        return this.repository.getTrack()
    }

    override suspend fun getTrackById(id: Int): Flow<Track> {
        TODO("Not yet implemented")
    }
}
