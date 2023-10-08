package at.interview.ohanaassignment.usage.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import at.interview.ohanaassignment.ui.theme.Typography
import at.interview.ohanaassignment.usage.domain.UsageViewModel

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

        // Toggling categories view mode between showing all the items and showing items equal to the value of numberOfCategoryItemsWhenCollapsed
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