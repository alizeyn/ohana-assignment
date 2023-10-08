package at.interview.ohanaassignment.usage.domain

import androidx.compose.ui.graphics.Color

data class CategoryUsage(
    val name: String,
    val numberOfApps: Int,
    val usagePresent: Float,
    val duration: String,
    val color: Color,
) {
    fun toUsage() = Usage(present = usagePresent, color = color)
}

data class Usage(val present: Float, val color: Color)