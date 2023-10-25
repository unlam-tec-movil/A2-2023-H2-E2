package ar.edu.unlam.mobile.scaffold.data.songs.models

import ar.edu.unlam.mobile.scaffold.data.artist.network.ArtistApiModel
import ar.edu.unlam.mobile.scaffold.domain.songs.models.Artist

data class ArtistsApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<ArtistApiModel>,
) {
    fun toArtist(): Artist {
        return Artist(
            id = items[0].id.toLong(),
            followers = items[0].followers.total,
            genres = items[0].genres,
            name = items[0].name,
            popularity = items[0].popularity,
        )
    }
}
