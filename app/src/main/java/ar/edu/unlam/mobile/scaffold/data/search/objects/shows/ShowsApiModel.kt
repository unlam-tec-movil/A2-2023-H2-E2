package ar.edu.unlam.mobile.scaffold.data.search.objects.shows

import ar.edu.unlam.mobile.scaffold.data.apiObjects.ShowItem

data class ShowsApiModel(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<ShowItem>,
)
