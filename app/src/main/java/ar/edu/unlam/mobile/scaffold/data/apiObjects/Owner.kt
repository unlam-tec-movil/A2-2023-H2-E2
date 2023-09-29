package ar.edu.unlam.mobile.scaffold.data.apiObjects

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val followers: Followers,
    val href: String,
    val id: String,
    val type: String,
    val uri: String,
    @SerializedName("display_name")
    val displayName: String
)