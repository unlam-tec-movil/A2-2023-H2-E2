package ar.edu.unlam.mobile.scaffold.domain.track.services

import ar.edu.unlam.mobile.scaffold.domain.authorization.services.AuthorizationGetter
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import kotlinx.coroutines.flow.Flow

interface TrackGetter {
    suspend fun getTrackById(id: Int): Flow<Track>
    suspend fun getTrendingTracks(authorizationGetter: AuthorizationGetter): Flow<List<Track>>
}
