package ar.edu.unlam.mobile.scaffold.data.songs.models

import ar.edu.unlam.mobile.scaffold.data.apiObjects.TrackItem

data class TracksApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<TrackItem>,
)
