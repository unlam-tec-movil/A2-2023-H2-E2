package ar.edu.unlam.mobile.scaffold.data.apimodels

data class SeedAPIModel(
    val initialPoolSize: Long,
    val afterFilteringSize: Long,
    val afterRelinkingSize: Long,
    val id: String,
    val type: String,
    val href: Any?,
)
