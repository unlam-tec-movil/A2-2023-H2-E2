package ar.edu.unlam.mobile.scaffold.data.apimodels.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String,
)
