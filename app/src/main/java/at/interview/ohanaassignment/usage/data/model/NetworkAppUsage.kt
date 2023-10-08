package at.interview.ohanaassignment.usage.data.model

import at.interview.ohanaassignment.usage.domain.model.AppUsage

data class NetworkAppUsage(
    val name: String,
    val iconUrl: String,
    val usagePresent: Float,
    val duration: String,
) {
    fun toAppUsage() = AppUsage(
        name = name,
        iconUrl = iconUrl,
        usagePresent = usagePresent,
        duration = duration,
    )
}