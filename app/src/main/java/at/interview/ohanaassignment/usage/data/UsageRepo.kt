package at.interview.ohanaassignment.usage.data

import at.interview.ohanaassignment.usage.domain.CategoryUsage

interface UsageRepo {

    fun getUsageByCategory(): List<CategoryUsage>
}