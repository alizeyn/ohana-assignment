package at.interview.ohanaassignment.usage.domain.model

data class AppUsage(
    val name: String,
    val logoUrl: String,
    val usagePresent: Float,
    val duration: String,
)