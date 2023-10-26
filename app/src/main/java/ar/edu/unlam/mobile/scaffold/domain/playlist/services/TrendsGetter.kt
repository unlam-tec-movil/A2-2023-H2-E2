package ar.edu.unlam.mobile.scaffold.domain.playlist.services

import ar.edu.unlam.mobile.scaffold.domain.playlist.models.Playlist
import kotlinx.coroutines.flow.Flow

interface TrendsGetter {
    suspend fun getTrendingPlaylist(): Flow<Playlist>
}
