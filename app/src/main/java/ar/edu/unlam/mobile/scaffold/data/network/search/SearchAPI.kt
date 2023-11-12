package ar.edu.unlam.mobile.scaffold.data.network.search

import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    @GET("v1/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String = "track",
    ): SearchApiModel
}
