package at.interview.ohanaassignment.usage.domain.model

data class AppUsage(
    val name: String,
    val iconUrl: String,
    val usagePresent: Float,
    val duration: String,
)