package ar.edu.unlam.mobile.scaffold.data.search.objects.audiobooks

import ar.edu.unlam.mobile.scaffold.data.apiObjects.AudiobookItem

data class Audiobooks(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<AudiobookItem>,
)
