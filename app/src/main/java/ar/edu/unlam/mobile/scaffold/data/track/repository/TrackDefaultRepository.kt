package ar.edu.unlam.mobile.scaffold.data.track.repository

import ar.edu.unlam.mobile.scaffold.data.track.network.TrackNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrackDefaultRepository @Inject constructor(val networkRepository: TrackNetworkRepository) :
    TrackRepository {
    override suspend fun getTrack(): Flow<Track> {
        return this.networkRepository.getRandomTrack().map { it.toTrack() }
    }
}