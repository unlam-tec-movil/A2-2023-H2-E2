package ar.edu.unlam.mobile.scaffold.domain.playlist.services

import ar.edu.unlam.mobile.scaffold.data.playlist.repository.PlaylistRepository
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import ar.edu.unlam.mobile.scaffold.domain.playlist.models.asModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrendsService @Inject constructor(private val playlistRepo: PlaylistRepository) : TrendsGetter {
    override suspend fun getTrendingPlaylist(): Flow<Playlist> {
        return flow {
            playlistRepo.getTrendingPlaylist()
                .map { it.asModel() }
                .collect {
                    emit(it)
                }
        }
    }
}
