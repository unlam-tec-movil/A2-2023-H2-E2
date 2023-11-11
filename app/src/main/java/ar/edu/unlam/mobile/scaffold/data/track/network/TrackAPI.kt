package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.Recommendation
import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import retrofit2.http.GET
import retrofit2.http.Query

interface TrackAPI {
    @GET("/tracks/{id}")
    suspend fun getTrack(): TrackAPIModel

    @GET("/v1/recommendations")
    suspend fun getRecommendations(
        @Query("limit") limit: Int,
        @Query("market") market: String,
        @Query("seed_genres") seedGenres: String,
        @Query("min_popularity") minPopularity: Int,
        @Query("max_popularity") maxPopularity: Int,
    ): Recommendation

    // Trae una playlist específica con las top 50 canciones del día
    @GET("/v1/playlists/37i9dQZEVXbMDoHDwVN2tF")
    suspend fun getTrendingTracks(
        @Query("market") market: String,
        @Query("fields") fields: String,
    ): Trend
}
