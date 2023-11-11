package ar.edu.unlam.mobile.scaffold.data.track.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.Recommendation
import ar.edu.unlam.mobile.scaffold.data.apimodels.trends.Trend
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TrackAPI {
    @GET("/tracks/{id}")
    suspend fun getTrack(): TrackAPIModel

    @GET("/v1/recommendations")
    @Headers("Authorization: Bearer BQC-O27rV-I4c-94cIuViQDRaQgCXLvCX1XnUZDU54cetzXHeZHRWv-qOSY9DNebObJEoO5YVy8yuGoRhoWC8FRVBrIcRwNPQwTZwD-fYywI0J5iA_I")
    suspend fun getRecommendations(
        @Query("limit") limit: Int,
        @Query("market") market: String,
        @Query("seed_genres") seedGenres: String,
        @Query("min_popularity") minPopularity: Int,
        @Query("max_popularity") maxPopularity: Int,
    ): Recommendation

    // Trae una playlist específica con las top 50 canciones del día
    /*TODO: cambiar por header dinamico que obtenga el token en tiempo real*/
    @GET("/v1/playlists/37i9dQZEVXbMDoHDwVN2tF")
    @Headers("Authorization: Bearer BQC-O27rV-I4c-94cIuViQDRaQgCXLvCX1XnUZDU54cetzXHeZHRWv-qOSY9DNebObJEoO5YVy8yuGoRhoWC8FRVBrIcRwNPQwTZwD-fYywI0J5iA_I")
    suspend fun getTrendingTracks(
        @Query("market") market: String,
        @Query("fields") fields: String,
    ): Trend
}
