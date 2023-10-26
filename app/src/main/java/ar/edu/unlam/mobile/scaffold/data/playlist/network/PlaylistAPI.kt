package ar.edu.unlam.mobile.scaffold.data.playlist.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PlaylistAPI {

    @GET("/playlists/{id}")
    suspend fun getById(
        @Query("id") id: String,
        @Header("Authorization:") accessToken: String,
    ): Flow<PlaylistApiModel>
}
