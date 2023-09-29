package ar.edu.unlam.mobile.scaffold.data.apiObjects

import com.google.gson.annotations.SerializedName

data class ResumePoint(
    @SerializedName("fully_played")
    val fullyPlayed: Boolean,
    @SerializedName("resume_position_ms")
    val resumePositionMs: Long
)