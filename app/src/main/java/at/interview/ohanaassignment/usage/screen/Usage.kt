package at.interview.ohanaassignment.usage.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.interview.ohanaassignment.UsageTopBar
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.ui.theme.Typography
import at.interview.ohanaassignment.usage.domain.CategoryUsage
import at.interview.ohanaassignment.usage.domain.UsageViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Usage() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            UsageTopBar()
        },
        content = { insets ->
            Box(
                modifier = Modifier
                    .padding(insets)
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                UsageByCategory()
            }
        }
    )
}

@Composable
fun UsageByCategory(modifier: Modifier = Modifier) {
    //TODO initiate by hilt
    val viewModel = UsageViewModel()
    Column {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Usage by category",
            style = Typography.titleLarge
        )

        UsageSpectrum(
            modifier = Modifier.padding(horizontal = 16.dp),
            usages = viewModel.usageByCategory.map { it.toUsage() }
        )

        LazyColumn(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.usageByCategory) {
                CategoryUsageItem(item = it)
            }
        }

    }
}

@Composable
fun CategoryUsageItem(item: CategoryUsage) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {

            CategoryColorIcon(color = item.color)

            Spacer(modifier = Modifier.size(4.dp))

            Column {
                Text(text = item.name, fontSize = 14.sp, color = Color.Black)

                Text(text = "${item.numberOfApps} Apps", fontSize = 8.sp, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.End) {
                if (item.usagePresent > 0.1) {
                    Text(
                        text = "${item.usagePresent * 100}%",
                        fontSize = 14.sp, color = Color.Black
                    )
                }

                Text(text = item.duration, fontSize = 8.sp, color = Color.DarkGray)
            }
        }
    }
}


@Composable
fun CategoryColorIcon(modifier: Modifier = Modifier, color: Color) {
    Box(
        modifier = modifier
            .size(16.dp)
            .clip(RoundedCornerShape(2.dp))
            .background(color)
    )
}

@Preview(showBackground = true)
@Composable
fun UsagePreview() {
    OhanaAssignmentTheme {
        Usage()
    }
}