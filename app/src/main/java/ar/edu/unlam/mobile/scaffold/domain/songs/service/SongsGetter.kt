package ar.edu.unlam.mobile.scaffold.domain.songs.service

import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import kotlinx.coroutines.flow.Flow

interface SongsGetter {
    fun getTrendingSongs(): Flow<List<Song>>
}
