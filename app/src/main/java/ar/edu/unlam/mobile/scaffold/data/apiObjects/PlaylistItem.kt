package ar.edu.unlam.mobile.scaffold.data.apiObjects

import com.google.gson.annotations.SerializedName

data class PlaylistItem(
    val collaborative: Boolean,
    val description: String,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val owner: Owner,
    val public: Boolean,
    @SerializedName("snapshot_id")
    val snapshotId: String,
    val tracks: Tracks,
    val type: String,
    val uri: String
)
