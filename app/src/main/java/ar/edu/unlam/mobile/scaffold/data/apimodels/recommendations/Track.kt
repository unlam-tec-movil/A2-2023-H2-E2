package ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations

import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import com.google.gson.annotations.SerializedName

data class Track(
    val album: Album,
    val artists: List<Artist>,
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
    @SerializedName("is_local")
    val isLocal: Boolean,
    @SerializedName("is_playable")
    val isPlayable: Boolean,
    val name: String,
    val popularity: Long,
    @SerializedName("preview_url")
    val previewUrl: String,
    @SerializedName("track_number")
    val trackNumber: Long,
    val type: String,
    val uri: String,
    @SerializedName("linked_from")
    val linkedFrom: LinkedFrom?,
) {
    fun toTrack(): Track {
        return Track(
            spotifyId = id,
            title = name,
            artist = artists[0].name,
            image = album.images[2].url,
        )
    }
}
