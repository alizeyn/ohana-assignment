package at.interview.ohanaassignment.usage.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.usage.ui.component.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsageScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            UsageTopBar()
        },
        content = { insets ->
            Column(
                modifier = Modifier
                    .padding(insets)
                    .background(Color.White)
            ) {
                UsedDevicesDropDownMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                AppsAndCategoriesUsageList(modifier = Modifier.padding(16.dp))
            }
        }
    )
}

@Composable
fun UsageTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column {
            MainAppBar()
            WeekNavigationBar(
                modifier = modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            )
            Separator()
        }
    }
}

@Composable
fun MainAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            TextButton(onClick = { }) {
                Image(imageVector = Icons.Rounded.ArrowBack, contentDescription = null)
            }
        }
        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            TextButton(onClick = { }) {
                Text(text = "Daily")
            }
        }
    }
}

@Composable
fun WeekNavigationBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            RoundedCornerIconButton(icon = Icons.Rounded.KeyboardArrowLeft, onClick = { })
        }

        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(text = "This Week")
        }

        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            RoundedCornerIconButton(icon = Icons.Rounded.KeyboardArrowRight, onClick = { })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsagePreview() {
    OhanaAssignmentTheme {
        UsageScreen()
    }
}