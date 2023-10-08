package at.interview.ohanaassignment.usage.domain

import androidx.lifecycle.ViewModel
import at.interview.ohanaassignment.usage.data.UsageRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsageViewModel @Inject constructor(usageRepo: UsageRepo) : ViewModel() {

    val usageByCategory = usageRepo.getUsageByCategory()

    val usedDevices = usageRepo.getDevices()
}