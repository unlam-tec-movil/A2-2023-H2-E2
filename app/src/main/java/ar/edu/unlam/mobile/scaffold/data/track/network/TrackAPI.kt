package ar.edu.unlam.mobile.scaffold.data.track.network

import retrofit2.http.GET

interface TrackAPI {
    @GET("/tracks/{id}")
    suspend fun getTrack(): TrackAPIModel
    @GET("/recommendations")
    suspend fun getTrackRecommendations(): List<TrackAPIModel>
}