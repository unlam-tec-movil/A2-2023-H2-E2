package ar.edu.unlam.mobile.scaffold.domain.songs.service

import ar.edu.unlam.mobile.scaffold.domain.songs.models.Song
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SongsService @Inject constructor() : SongsGetter {
    override fun getTrendingSongs(): Flow<List<Song>> {
        return flow {
            emit(
                listOf(
                    Song("1", "Song 1", "https://upload.wikimedia.org/wikipedia/en/9/9c/MilesDavisKindofBlue.jpg"),
                    Song("2", "Song 2", "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg"),
                    Song("3", "Song 3", "https://upload.wikimedia.org/wikipedia/en/9/9b/Hot_Rats_%28Frank_Zappa_album_-_cover_art%29.jpg"),
                ),
            )
        }
    }
}
