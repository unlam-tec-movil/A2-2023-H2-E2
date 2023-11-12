package ar.edu.unlam.mobile.scaffold.data.apimodels

import ar.edu.unlam.mobile.scaffold.domain.track.models.Track

data class Track(
    val href: String,
    val limit: Int,
    val next: String,
    val offset: Int,
    val previous: String,
    val total: Int,
    val items: List<SimplifiedTrack>,
)


