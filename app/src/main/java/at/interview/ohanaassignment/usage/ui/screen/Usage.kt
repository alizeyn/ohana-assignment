package at.interview.ohanaassignment.usage.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.interview.ohanaassignment.UsageTopBar
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.usage.ui.component.UsageByCategory
import at.interview.ohanaassignment.usage.ui.component.UsedDevicesDropDownMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Usage() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            UsageTopBar()
        },
        content = { insets ->
            Column(
                modifier = Modifier
                    .padding(insets)
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                UsedDevicesDropDownMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                UsageByCategory(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun UsagePreview() {
    OhanaAssignmentTheme {
        Usage()
    }
}