package ar.edu.unlam.mobile.scaffold.data.apiObjects

import ar.edu.unlam.mobile.scaffold.data.artist.network.ArtistApiModel
import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("album_type")
    val albumType: String,
    @SerializedName("total_tracks")
    val totalTracks: Int,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
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
    val artists: List<ArtistApiModel>,
)
