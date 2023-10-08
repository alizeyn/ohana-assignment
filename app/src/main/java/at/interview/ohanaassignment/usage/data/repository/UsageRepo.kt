package at.interview.ohanaassignment.usage.data.repository

import at.interview.ohanaassignment.usage.domain.model.AppUsage
import at.interview.ohanaassignment.usage.domain.model.CategoryUsage
import at.interview.ohanaassignment.usage.domain.model.Device

interface UsageRepo {

    fun getUsageByCategory(): List<CategoryUsage>

    fun getDevices(): List<Device>

    fun getUsageByApp(): List<AppUsage>
}