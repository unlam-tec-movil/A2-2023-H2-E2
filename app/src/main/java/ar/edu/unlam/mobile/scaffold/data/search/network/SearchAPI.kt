package ar.edu.unlam.mobile.scaffold.data.search.network

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SearchAPI {

    @GET("/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: List<String> = listOf("track, artist"),
        @Header("Authorization:") auth: String
    ): SearchApiModel
}
