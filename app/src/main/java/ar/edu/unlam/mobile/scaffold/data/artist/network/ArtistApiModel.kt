package ar.edu.unlam.mobile.scaffold.data.artist.network

import ar.edu.unlam.mobile.scaffold.data.apiObjects.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apiObjects.Followers
import ar.edu.unlam.mobile.scaffold.data.apiObjects.Image
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
