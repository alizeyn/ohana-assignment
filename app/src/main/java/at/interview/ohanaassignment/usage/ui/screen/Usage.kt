package at.interview.ohanaassignment.usage.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import at.interview.ohanaassignment.UsageTopBar
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.ui.theme.Typography
import at.interview.ohanaassignment.usage.domain.UsageViewModel
import at.interview.ohanaassignment.usage.ui.component.*

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
fun AppsAndCategoriesUsageList(modifier: Modifier = Modifier, numberOfCategoryItemsWhenCollapsed: Int = 5) {

    val viewModel = hiltViewModel<UsageViewModel>()

    val showAll = remember { mutableStateOf(false) }

    val categories = viewModel.usageByCategory
    val categoriesToShow = if (showAll.value || categories.size <= numberOfCategoryItemsWhenCollapsed) categories else categories.take(numberOfCategoryItemsWhenCollapsed)

    val apps = viewModel.usageByApp

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {

        item {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Usage by category",
                style = Typography.titleLarge
            )
        }

        item {
            UsageSpectrum(
                modifier = Modifier.padding(bottom = 32.dp),
                usages = viewModel.usageByCategory.map { it.toUsage() }
            )
        }

        items(categoriesToShow) {
            CategoryUsageItem(item = it)
        }

        // Toggling categories view mode
        if (categories.size > numberOfCategoryItemsWhenCollapsed) {
            if (!showAll.value) {
                item {
                    TextButton(onClick = { showAll.value = true }) {
                        Text("Show all categories")
                    }
                }
            } else {
                item {
                    TextButton(onClick = { showAll.value = false }) {
                        Text("Show less")
                    }
                }
            }
        }

        item {
            Separator()
        }

        item {
            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = "Usage by Apps",
                style = Typography.titleLarge
            )
        }

        items(apps) {
            AppUsageItem(item = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsagePreview() {
    OhanaAssignmentTheme {
        Usage()
    }
}