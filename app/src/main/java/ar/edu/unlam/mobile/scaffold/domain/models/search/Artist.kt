package ar.edu.unlam.mobile.scaffold.domain.models.search

data class Artist(
    val id: Long,
    val name: String,
    val popularity: Int,
    val followers: Int,
    val genres: List<String>,
)
