package ar.edu.unlam.mobile.scaffold.data.apimodels.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apimodels.Restriction
import ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations.ExternalIds
import ar.edu.unlam.mobile.scaffold.domain.track.models.Track
import com.google.gson.annotations.SerializedName

data class Track (
    val album: Album,
    val artists: List<Artist>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("disc_number")
    val discNumber: Long,
    @SerializedName("duration_ms")
    val durationMs: Long,
    val explicit: Boolean,
    @SerializedName("external_ids")
    val externalIds: ExternalIds,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    @SerializedName("is_playable")
    val isPlayable: Boolean,
    @SerializedName("linked_from")
    val linkedFrom: Map<String, Any>,
    val restrictions: Restriction,
    val name: String,
    val popularity: Long,
    @SerializedName("preview_url")
    val previewUrl: String,
    @SerializedName("track_number")
    val trackNumber: Long,
    val type: String,
    val uri: String,
    @SerializedName("is_local")
    val isLocal: Boolean
){
    fun toTrack():Track{
        return Track(
            title = name,
            artist = artists[0].name,
            image = album.images[0].url,
            spotifyId = id,
            srcSpotify = ""
            )
    }
}