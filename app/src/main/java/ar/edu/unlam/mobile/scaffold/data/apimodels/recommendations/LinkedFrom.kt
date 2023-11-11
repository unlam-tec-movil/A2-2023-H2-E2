package ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations

import com.google.gson.annotations.SerializedName

data class LinkedFrom(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val type: String,
    val uri: String,
)
