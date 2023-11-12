package ar.edu.unlam.mobile.scaffold.data.track.repository

import ar.edu.unlam.mobile.scaffold.data.track.network.TrackNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrackDefaultRepository @Inject constructor(val networkRepository: TrackNetworkRepository) :
    TrackRepository {
    override suspend fun getRecommendations(): Flow<List<Track>> {
        return this.networkRepository.getRecommendations().map { it.tracks.map { it.toTrack() } }
    }

    override suspend fun getTrendingTracks(): Flow<List<Track>> {
        return this.networkRepository.getTrendingTracks()
            .map { it.tracks.items.map { it.track.toTrack() } }
    }

    override suspend fun getSimpleTrack(trackId: String): Flow<Track> {
        return this.networkRepository.getSimpleTrack(trackId)
            .map {it.toTrack()}
    }
}
