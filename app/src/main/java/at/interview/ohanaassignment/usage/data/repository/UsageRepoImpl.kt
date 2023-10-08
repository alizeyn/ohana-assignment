package at.interview.ohanaassignment.usage.data.repository

import androidx.compose.ui.graphics.Color
import at.interview.ohanaassignment.usage.data.model.NetworkAppUsage
import at.interview.ohanaassignment.usage.data.model.NetworkCategoryUsage
import at.interview.ohanaassignment.usage.data.model.NetworkDevice

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

    override fun getUsageByApp() = listOf(
        NetworkAppUsage(
            name = "Instagram",
            iconUrl = "https://play-lh.googleusercontent.com/VRMWkE5p3CkWhJs6nv-9ZsLAs1QOg5ob1_3qg-rckwYW7yp1fMrYZqnEFpk0IoVP4LM",
            usagePresent = 0.55f,
            duration = "8h 12m"
        ),
        NetworkAppUsage(
            name = "TikTok",
            iconUrl = "https://play-lh.googleusercontent.com/BmUViDVOKNJe0GYJe22hsr7juFndRVbvr1fGmHGXqHfJjNAXjd26bfuGRQpVrpJ6YbA",
            usagePresent = 0.2f,
            duration = "2h 27m"
        ),
        NetworkAppUsage(
            name = "Minecraft",
            iconUrl = "https://play-lh.googleusercontent.com/VSwHQjcAttxsLE47RuS4PqpC4LT7lCoSjE7Hx5AW_yCxtDvcnsHHvm5CTuL5BPN-uRTP",
            usagePresent = 0.25f,
            duration = "1h 21m"
        ),
        NetworkAppUsage(
            name = "Roblox",
            iconUrl = "https://play-lh.googleusercontent.com/WNWZaxi9RdJKe2GQM3vqXIAkk69mnIl4Cc8EyZcir2SKlVOxeUv9tZGfNTmNaLC717Ht",
            usagePresent = 0.2f,
            duration = "32m"
        ),
        NetworkAppUsage(
            name = "YouTube",
            iconUrl = "https://play-lh.googleusercontent.com/lMoItBgdPPVDJsNOVtP26EKHePkwBg-PkuY9NOrc-fumRtTFP4XhpUNk_22syN4Datc",
            usagePresent = 0.1f,
            duration = "17m"
        ),
    ).map { it.toAppUsage() }
}