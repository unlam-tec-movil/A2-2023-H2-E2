package ar.edu.unlam.mobile.scaffold.domain.services.track

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrackMockService @Inject constructor() : TrackGetter {
    override suspend fun getRecommendations(): Flow<List<Track>> {
        return flow {
            emit(
                listOf(
                    Track(
                        title = "In Da Club",
                        artist = "50 Cent",
                        image = "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG",
                        spotifyId = "",
                    ),
                    Track(
                        title = "In Da Club",
                        artist = "50 Cent",
                        image = "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG",
                        spotifyId = "",
                    ),
                ),
            )
        }
    }

    override suspend fun getTrackById(id: Int): Flow<Track> {
        return flow {
            emit(
                Track(
                    title = "In Da Club",
                    artist = "50 Cent",
                    image = "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG",
                    spotifyId = "",
                ),
            )
        }
    }

    override suspend fun getTrendingTracks(): Flow<List<Track>> {
        return flow {
            emit(
                listOf(
                    Track(
                        title = "In Da Club",
                        artist = "50 Cent",
                        image = "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG",
                        spotifyId = "",
                    ),
                    Track(
                        title = "In Da Club",
                        artist = "50 Cent",
                        image = "https://upload.wikimedia.org/wikipedia/en/9/9d/Get_Rich_Or_Die_Tryin%27.JPG",
                        spotifyId = "",
                    ),
                ),
            )
        }
    }
}
