package ar.edu.unlam.mobile.scaffold.data.search.objects.episodes

import ar.edu.unlam.mobile.scaffold.data.apiObjects.EpisodeItem

data class EpisodesApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<EpisodeItem>
)