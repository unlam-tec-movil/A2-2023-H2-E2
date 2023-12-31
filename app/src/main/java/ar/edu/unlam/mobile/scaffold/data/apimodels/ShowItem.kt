package ar.edu.unlam.mobile.scaffold.data.apimodels

import com.google.gson.annotations.SerializedName

data class ShowItem(
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    val copyrights: List<Copyright>,
    val description: String,
    @SerializedName("html_description")
    val htmlDescription: String,
    val explicit: Boolean,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val href: String,
    val id: String,
    val images: List<Image>,
    @SerializedName("is_externally_hosted")
    val isExternallyHosted: Boolean,
    val languages: List<String>,
    @SerializedName("media_type")
    val mediaType: String,
    val name: String,
    val publisher: String,
    val type: String,
    val uri: String,
    @SerializedName("total_episodes")
    val totalEpisodes: Int,
)
