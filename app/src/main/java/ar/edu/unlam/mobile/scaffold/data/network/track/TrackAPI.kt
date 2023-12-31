package ar.edu.unlam.mobile.scaffold.data.network.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.Recommendation
import ar.edu.unlam.mobile.scaffold.data.apimodels.track.Track
import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrackAPI {
    @GET("/v1/tracks/{id}")
    suspend fun getTrack(@Path("id") id: String, @Query("market") market: String): Track

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
