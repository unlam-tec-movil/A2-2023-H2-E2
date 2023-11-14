package ar.edu.unlam.mobile.scaffold.data.apimodels.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apimodels.Restriction
import ar.edu.unlam.mobile.scaffold.domain.models.track.FullTrack
import com.google.gson.annotations.SerializedName

data class Track(
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
    val isLocal: Boolean,
) {
    fun toFullTrack(): FullTrack {
        return FullTrack(
            spotifyId = id,
            title = name,
            artists = artists.map { it.toArtist() },
            album = album.name,
            image = album.images[0].url,
            releaseDate = album.releaseDate,
            duration = durationMs,
        )
    }
}
