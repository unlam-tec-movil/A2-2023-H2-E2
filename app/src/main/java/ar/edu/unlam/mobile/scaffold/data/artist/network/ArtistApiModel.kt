package ar.edu.unlam.mobile.scaffold.data.artist.network

import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apimodels.Followers
import ar.edu.unlam.mobile.scaffold.data.apimodels.Image
import com.google.gson.annotations.SerializedName

data class ArtistApiModel(
    @SerializedName("external_urls") val externalUrls: ExternalUrls,
    val followers: Followers,
    val genres: List<String>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val popularity: Int,
    val type: String,
    val uri: String,
)
