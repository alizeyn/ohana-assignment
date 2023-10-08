package at.interview.ohanaassignment.usage.data.model

import at.interview.ohanaassignment.usage.domain.model.Device

data class NetworkDevice(val name: String) {
    fun toDevice() = Device(name = name)
}
