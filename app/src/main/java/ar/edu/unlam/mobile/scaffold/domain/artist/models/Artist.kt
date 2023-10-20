package ar.edu.unlam.mobile.scaffold.domain.artist.models

data class Artist(
    val id: Long,
    val name: String,
    val popularity: Int,
    val followers: Int,
    val genres: List<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Artist

        if (id != other.id) return false
        if (name != other.name) return false
        if (popularity != other.popularity) return false
        if (followers != other.followers) return false
        if (genres != other.genres) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + popularity
        result = 31 * result + followers
        result = 31 * result + genres.hashCode()
        return result
    }
}