package ar.edu.unlam.mobile.scaffold.data.songs.network

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SongsAPI {

    @Headers("Authorization: Bearer BQBAWrrZHs1LSa5h2HborWrPVAB0vBhyh-J5HmiMFY4gWX2r5w3N6zRpNwmCDOIxLv8ApT9qy9ij6rLrhpustUxHaQva97oO7rIYgb8BfYH0HXPeY-I")
    @GET("v1/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type") type: String = "track"
    ): SongsApiModel
}
