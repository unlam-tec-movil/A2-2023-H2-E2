package ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("album_type")
    val albumType: String,
    val artists: List<Artist>,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    @SerializedName("is_playable")
    val isPlayable: Boolean,
    val name: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,
    @SerializedName("total_tracks")
    val totalTracks: Long,
    val type: String,
    val uri: String,
)
