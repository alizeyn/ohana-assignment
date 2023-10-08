package at.interview.ohanaassignment.usage.data.model

import androidx.compose.ui.graphics.Color
import at.interview.ohanaassignment.usage.domain.model.CategoryUsage

data class NetworkCategoryUsage(
    val name: String,
    val numberOfApps: Int,
    val usagePresent: Float,
    val duration: String? = null,
    val color: Color,
) {
    fun toCategoryUsagePresent() = CategoryUsage(
        name = name,
        numberOfApps = numberOfApps,
        usagePresent = usagePresent,
        duration = duration ?: "--",
        color = color,
    )
}