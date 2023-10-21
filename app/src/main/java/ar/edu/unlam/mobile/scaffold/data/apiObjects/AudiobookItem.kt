package ar.edu.unlam.mobile.scaffold.data.apiObjects

import com.google.gson.annotations.SerializedName

data class AudiobookItem(
    val authors: List<Author>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    val copyrights: List<Copyright>,
    val description: String,
    @SerializedName("html_description")
    val htmlDescription: String,
    val edition: String,
    val explicit: Boolean,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    val languages: List<String>,
    @SerializedName("media_type")
    val mediaType: String,
    val name: String,
    val narrators: List<Narrator>,
    val publisher: String,
    val type: String,
    val uri: String,
    @SerializedName("total_chapters")
    val totalChapters: Int
)
