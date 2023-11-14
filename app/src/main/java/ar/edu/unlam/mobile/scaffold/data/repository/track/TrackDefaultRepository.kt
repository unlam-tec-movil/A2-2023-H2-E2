package ar.edu.unlam.mobile.scaffold.data.repository.track

import ar.edu.unlam.mobile.scaffold.data.database.dao.TrackDao
import ar.edu.unlam.mobile.scaffold.data.network.track.TrackNetworkRepository
import ar.edu.unlam.mobile.scaffold.domain.models.track.FullTrack
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrackDefaultRepository @Inject constructor(
    private val networkRepository: TrackNetworkRepository,
    private val trackDao: TrackDao,
) : TrackRepository {
    override suspend fun getRecommendations(): Flow<List<Track>> {
        return this.networkRepository.getRecommendations().map { it.tracks.map { it.toTrack() } }
    }

    override suspend fun getTrendingTracks(): Flow<List<Track>> {
        return this.networkRepository.getTrendingTracks()
            .map { it.tracks.items.map { it.track.toTrack() } }
    }

    override suspend fun getAPITrack(id: String): Flow<FullTrack> {
        return this.networkRepository.getAPITrack(id).map { it.toFullTrack() }
    }

    fun insertTrack(trackToInsert: Track) {
        trackDao.insert(trackToInsert.toTrackEntity())
    }

    fun deleteTrack(trackToDelete: Track) {
        trackDao.delete(trackToDelete.toTrackEntity())
    }

    fun updateTrack(trackToUpdate: Track) {
        trackDao.update(trackToUpdate.toTrackEntity())
    }

    fun getTrack(id: String): Flow<Track> {
        return this.trackDao.get(id).map { it.toDomainTrack() }
    }

    fun getAllTracks(): Flow<List<Track>> {
        return this.trackDao.getAll().map { it.map { it.toDomainTrack() } }
    }
}
