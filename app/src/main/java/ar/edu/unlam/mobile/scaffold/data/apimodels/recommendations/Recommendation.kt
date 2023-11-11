package ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations

data class Recommendation(
    val tracks: List<Track>,
    val seeds: List<Seed>,
)
