package ar.edu.unlam.mobile.scaffold.data.songs.network

import retrofit2.http.GET
import retrofit2.http.Query

interface SongsAPI {

    @GET("v1/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String = "track",
    ): SongsApiModel
}
