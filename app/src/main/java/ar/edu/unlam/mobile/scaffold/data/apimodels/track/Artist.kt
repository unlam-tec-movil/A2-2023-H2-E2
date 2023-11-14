package ar.edu.unlam.mobile.scaffold.data.apimodels.track

import ar.edu.unlam.mobile.scaffold.data.apimodels.ExternalUrls
import ar.edu.unlam.mobile.scaffold.data.apimodels.Followers
import ar.edu.unlam.mobile.scaffold.data.apimodels.Image
import ar.edu.unlam.mobile.scaffold.domain.models.track.Artist
import com.google.gson.annotations.SerializedName

data class Artist(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val followers: Followers,
    val genres: List<String>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val popularity: Long,
    val type: String,
    val uri: String,
) {
    fun toArtist(): Artist {
        return Artist(
            name = name,
            image = if (images != null) images.get(0).url else "https://cdn-icons-png.flaticon.com/512/149/149071.png",
        )
    }
}
