package at.interview.ohanaassignment.usage.domain

import androidx.lifecycle.ViewModel
import at.interview.ohanaassignment.usage.data.repository.UsageRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsageViewModel @Inject constructor(usageRepo: UsageRepo) : ViewModel() {

    val usageByCategory = usageRepo.getUsageByCategory()

    val usageByApp = usageRepo.getUsageByApp()

    val usedDevices = usageRepo.getDevices()
}