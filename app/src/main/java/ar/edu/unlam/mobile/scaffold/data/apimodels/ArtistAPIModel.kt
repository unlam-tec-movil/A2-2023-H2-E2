package ar.edu.unlam.mobile.scaffold.data.apimodels

import com.google.gson.annotations.SerializedName

data class ArtistAPIModel(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String,
)
