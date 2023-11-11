package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackAPI {
    @GET("/tracks/{id}")
    suspend fun getTrack(): TrackAPIModel

    // Trae una playlist específica con las top 50 canciones del día
    /*TODO: cambiar por header dinamico que obtenga el token en tiempo real*/
    @Headers("Authorization: Bearer BQBAWrrZHs1LSa5h2HborWrPVAB0vBhyh-J5HmiMFY4gWX2r5w3N6zRpNwmCDOIxLv8ApT9qy9ij6rLrhpustUxHaQva97oO7rIYgb8BfYH0HXPeY-I")
    @GET("/v1/playlists/37i9dQZEVXbMDoHDwVN2tF")
    suspend fun getTrendingTracks(
        @Query("market") market: String,
        @Query("fields") fields: String,
    ): Trend
}
