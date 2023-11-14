package ar.edu.unlam.mobile.scaffold.data.apimodels.recommendations

data class Seed(
    val initialPoolSize: Long,
    val afterFilteringSize: Long,
    val afterRelinkingSize: Long,
    val id: String,
    val type: String,
    val href: Any?,
)
