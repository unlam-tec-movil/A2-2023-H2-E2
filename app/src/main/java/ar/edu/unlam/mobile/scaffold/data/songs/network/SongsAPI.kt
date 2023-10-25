package ar.edu.unlam.mobile.scaffold.data.songs.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SongsAPI {

    @GET("/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: List<String> = listOf("track, artist"),
        @Header("Authorization:") auth: String,
    ): SongsApiModel
}
