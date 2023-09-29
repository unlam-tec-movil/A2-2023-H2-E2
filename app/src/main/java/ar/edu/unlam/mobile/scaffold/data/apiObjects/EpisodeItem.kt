package ar.edu.unlam.mobile.scaffold.data.apiObjects

import com.google.gson.annotations.SerializedName

data class EpisodeItem(
    @SerializedName("audio_preview_url")
    val audioPreviewUrl: String,
    val description: String,
    @SerializedName("html_description")
    val htmlDescription: String,
    @SerializedName("duration_ms")
    val durationMs: Long,
    val explicit: Boolean,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    @SerializedName("is_externally_hosted")
    val isExternallyHosted: Boolean,
    @SerializedName("is_playable")
    val isPlayable: Boolean,
    val language: String,
    val languages: List<String>,
    val name: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,
    @SerializedName("resume_point")
    val resumePoint: ResumePoint,
    val type: String,
    val uri: String,
    val restrictions: Restriction
)