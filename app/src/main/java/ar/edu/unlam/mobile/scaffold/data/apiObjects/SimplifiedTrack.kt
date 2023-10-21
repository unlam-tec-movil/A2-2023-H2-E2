package ar.edu.unlam.mobile.scaffold.data.apiObjects

data class SimplifiedTrack(
    val artist: SimplifiedArtist,
    val available_markets: List<String>,
    val disc_number: Int,
    val duration_ms: Int,
    val explicit: Boolean,
    val external_urls: ExternalUrls,
    val href: String,
    val id: String,
    val is_playable: Boolean,
    val linked_from: LinkedFrom,
    val restrictions: Restriction,
    val name: String,
    val preview_url: String,
    val track_number: Int,
    val type: String,
    val uri: String,
    val is_local: Boolean
)