package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TrackAPI {
    @GET("/tracks/{id}")
    suspend fun getTrack(): TrackAPIModel

    /*TODO: cambiar por header dinamico que obtenga el token en tiempo real*/
    @Headers("Authorization: Bearer BQAPuE9s7ualNimZQqb3QQdFy6vpbb2MJMPzmXr49kZ9RXcNJf-yIIT5wXn3RGTdWp9YWFkPNsXTwq3s2mlRkNCZ_838tC_l7WOdxHQILiW0khoZVX8")
    @GET("/v1/playlists/37i9dQZEVXbMDoHDwVN2tF")
    suspend fun getTrendingTracks(
        @Query("market") market: String,
        @Query("fields") fields: String,
    ): Trend
}
