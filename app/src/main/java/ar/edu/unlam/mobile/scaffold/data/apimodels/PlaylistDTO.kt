package ar.edu.unlam.mobile.scaffold.data.apimodels

data class PlaylistDTO(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<PlaylistItem>,
)
