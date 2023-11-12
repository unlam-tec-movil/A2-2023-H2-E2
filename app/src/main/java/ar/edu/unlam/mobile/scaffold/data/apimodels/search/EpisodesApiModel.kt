package ar.edu.unlam.mobile.scaffold.data.apimodels.search

import ar.edu.unlam.mobile.scaffold.data.apimodels.EpisodeItem

data class EpisodesApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<EpisodeItem>,
)
