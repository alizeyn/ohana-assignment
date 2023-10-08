package at.interview.ohanaassignment.usage.domain

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import at.interview.ohanaassignment.usage.data.UsageRepo
import at.interview.ohanaassignment.usage.data.UsageRepoImpl

class UsageViewModel: ViewModel() {

    //TODO inject with hilt
    private val usageRepo: UsageRepo by lazy { UsageRepoImpl() }

    val usageByCategory = usageRepo.getUsageByCategory()
}