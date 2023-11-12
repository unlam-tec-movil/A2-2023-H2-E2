package ar.edu.unlam.mobile.scaffold.data.network.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.Album
import ar.edu.unlam.mobile.scaffold.data.apimodels.ArtistAPIModel
import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalId
import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import ar.edu.unlam.mobile.scaffold.domain.models.track.Track
import com.google.gson.annotations.SerializedName

data class TrackAPIModel(
    val album: Album,
    val artists: List<ArtistAPIModel>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    @SerializedName("disc_number")
    val discNumber: Long,
    @SerializedName("duration_ms")
    val durationMs: Long,
    val explicit: Boolean,
    @SerializedName("external_ids")
    val externalIds: ExternalId,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    @SerializedName("is_local")
    val isLocal: Boolean,
    val name: String,
    val popularity: Long,
    @SerializedName("preview_url")
    val previewUrl: Any?,
    @SerializedName("track_number")
    val trackNumber: Long,
    val type: String,
    val uri: String,
) {
    fun toTrack(): Track {
        return Track(
            spotifyId = id,
            title = name,
            artist = artists[0].name,
            image = album.images[0].url,
            srcSpotify = externalUrls.spotify,
        )
    }
}
