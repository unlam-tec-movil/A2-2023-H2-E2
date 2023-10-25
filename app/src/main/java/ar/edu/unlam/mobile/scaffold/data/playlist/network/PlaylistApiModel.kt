package ar.edu.unlam.mobile.scaffold.data.playlist.network

import ar.edu.unlam.mobile.scaffold.data.apiObjects.PlaylistItem
import ar.edu.unlam.mobile.scaffold.data.playlist.models.PlaylistDTO

data class PlaylistApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<PlaylistItem>,
)

fun PlaylistApiModel.toDTO() = PlaylistDTO(
    href = href,
    limit = limit,
    next = next,
    offset = offset,
    previous = previous,
    total = total,
    items = items,
)
