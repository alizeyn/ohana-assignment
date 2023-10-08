package at.interview.ohanaassignment.usage.data

import at.interview.ohanaassignment.usage.domain.CategoryUsage
import at.interview.ohanaassignment.usage.domain.Device

interface UsageRepo {

    fun getUsageByCategory(): List<CategoryUsage>

    fun getDevices(): List<Device>
}