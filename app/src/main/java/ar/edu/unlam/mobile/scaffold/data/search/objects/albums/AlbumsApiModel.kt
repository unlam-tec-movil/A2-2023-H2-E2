package ar.edu.unlam.mobile.scaffold.data.search.objects.albums

import ar.edu.unlam.mobile.scaffold.data.apiObjects.Album

data class AlbumsApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<Album>,
)