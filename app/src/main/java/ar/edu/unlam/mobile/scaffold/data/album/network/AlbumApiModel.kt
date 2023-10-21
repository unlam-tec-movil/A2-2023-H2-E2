package ar.edu.unlam.mobile.scaffold.data.album.network

import ar.edu.unlam.mobile.scaffold.data.apiObjects.Copyright
import ar.edu.unlam.mobile.scaffold.data.apiObjects.ExternalId
import ar.edu.unlam.mobile.scaffold.data.apiObjects.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apiObjects.Image
import ar.edu.unlam.mobile.scaffold.data.apiObjects.Restriction
import ar.edu.unlam.mobile.scaffold.data.apiObjects.SimplifiedArtist
import ar.edu.unlam.mobile.scaffold.data.apiObjects.Tracks
import com.google.gson.annotations.SerializedName

data class AlbumApiModel(
    @SerializedName("album_type") val albumType: String,
    @SerializedName("total_tracks") val totalTracks: Int,
    @SerializedName("available_markets") val availableMarkets: List<String>,
    @SerializedName("external_urls") val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("release_date_precision") val releaseDatePrecision: String,
    @SerializedName("restrictions") val restriction: Restriction,
    val type: String,
    val uri: String,
    val artists: List<SimplifiedArtist>,
    val tracks: Tracks,
    val copyrights: List<Copyright>,
    @SerializedName("external_ids") val externalIds: ExternalId,
    val genres: List<String>,
    val label: String,
    val popularity: Int,
)