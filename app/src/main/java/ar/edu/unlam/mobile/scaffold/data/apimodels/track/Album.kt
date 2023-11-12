package ar.edu.unlam.mobile.scaffold.data.apimodels.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apimodels.Image
import ar.edu.unlam.mobile.scaffold.data.apimodels.Restriction
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("album_type")
    val albumType: String,
    @SerializedName("total_tracks")
    val totalTracks: Long,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,
    val restrictions: Restriction,
    val type: String,
    val uri: String,
    val artists: List<Artist>,
)
