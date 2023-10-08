package at.interview.ohanaassignment.usage.data

import androidx.compose.ui.graphics.Color

class UsageRepoImpl : UsageRepo {

    override fun getUsageByCategory() = listOf(
        NetworkCategoryUsage(
            name = "Social",
            numberOfApps = 14,
            usagePresent = 0.52f,
            duration = "1h 52m",
            color = Color.Red
        ),
        NetworkCategoryUsage(
            name = "Games",
            numberOfApps = 14,
            usagePresent = 0.21f,
            duration = "1h 52m",
            color = Color.Blue
        ),
        NetworkCategoryUsage(
            name = "Education",
            numberOfApps = 14,
            usagePresent = 0.13f,
            duration = "1h 52m",
            color = Color.Magenta
        ),
        NetworkCategoryUsage(
            name = "Productivity",
            numberOfApps = 14,
            usagePresent = 0.8f,
            duration = "1h 52m",
            color = Color.Cyan
        ),
        NetworkCategoryUsage(
            name = "Messaging",
            numberOfApps = 14,
            usagePresent = 0.02f,
            color = Color.Yellow,
        ),
        NetworkCategoryUsage(
            name = "Other",
            numberOfApps = 14,
            usagePresent = 0.4f,
            duration = "1h 52m",
            color = Color.DarkGray
        ),
    ).map { it.toCategoryUsagePresent() }

    override fun getDevices() = listOf(
        NetworkDevice(name = "Pixel 8"),
        NetworkDevice(name = "Pixel 6"),
        NetworkDevice(name = "Pixel 2"),
        NetworkDevice(name = "Pixel 4"),
    ).map { it.toDevice() }
}