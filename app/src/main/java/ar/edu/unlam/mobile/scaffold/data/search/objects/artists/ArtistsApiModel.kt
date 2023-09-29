package ar.edu.unlam.mobile.scaffold.data.search.objects.artists

import ar.edu.unlam.mobile.scaffold.data.artist.network.ArtistApiModel

data class ArtistsApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<ArtistApiModel>
)