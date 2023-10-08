package at.interview.ohanaassignment.usage.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import at.interview.ohanaassignment.usage.domain.UsageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsedDevicesDropDownMenu(modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<UsageViewModel>()
    val usedDevices = viewModel.usedDevices
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(usedDevices[0]) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            readOnly = true,
            value = selectedOptionText.name,
            onValueChange = { },
            singleLine = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            viewModel.usedDevices.forEach {
                DropdownMenuItem(
                    text = { Text(text = it.name) },
                    onClick = {
                        selectedOptionText = it
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsedDeviceDropDownMenu() {
    UsedDevicesDropDownMenu()
}