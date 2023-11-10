package ar.edu.unlam.mobile.scaffold.data.apimodels

import com.google.gson.annotations.SerializedName

data class TrackItem(
    val album: Album,
    val artists: List<SimplifiedArtist>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("disc_number")
    val discNumber: Int,
    @SerializedName("duration_ms")
    val durationMs: Long,
    val explicit: Boolean,
    @SerializedName("external_ids")
    val externalIds: ExternalId,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    @SerializedName("is_playable")
    val isPlayable: Boolean,
    @SerializedName("linked_from")
    val linkedFrom: LinkedFrom,
    val restrictions: Restriction,
    val name: String,
    val popularity: Int,
    @SerializedName("preview_url")
    val previewUrl: String,
    @SerializedName("track_number")
    val trackNumber: Int,
    val type: String,
    val uri: String,
    @SerializedName("is_local")
    val isLocal: Boolean,
)
