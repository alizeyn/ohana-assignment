package at.interview.ohanaassignment.usage.data

import at.interview.ohanaassignment.usage.domain.Device

data class NetworkDevice(val name: String) {
    fun toDevice() = Device(name = name)
}
