package at.interview.ohanaassignment.usage.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.interview.ohanaassignment.ui.theme.Typography
import at.interview.ohanaassignment.usage.domain.CategoryUsage
import at.interview.ohanaassignment.usage.domain.UsageViewModel
import kotlin.math.roundToInt

@Composable
fun UsageByCategory(modifier: Modifier = Modifier) {
    //TODO initiate by hilt
    val viewModel = UsageViewModel()
    Column(modifier = modifier) {

        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Usage by category",
            style = Typography.titleLarge
        )

        UsageSpectrum(
            modifier = Modifier.padding(bottom = 32.dp),
            usages = viewModel.usageByCategory.map { it.toUsage() }
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(viewModel.usageByCategory) {
                CategoryUsageItem(item = it)
            }
        }

    }
}

@Composable
fun CategoryUsageItem(modifier: Modifier = Modifier, item: CategoryUsage) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row(modifier = Modifier.padding(16.dp)) {

            CategoryColorIcon(
                modifier = Modifier.padding(top = 6.dp, end = 8.dp),
                color = item.color
            )

            Spacer(modifier = Modifier.size(4.dp))

            Column {
                Text(text = item.name, fontSize = 16.sp, color = Color.Black)
                Text(text = "${item.numberOfApps} Apps", fontSize = 12.sp, color = Color.DarkGray)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.End) {

                Text(text = item.duration, fontSize = 14.sp, color = Color.Black)
                // Only show more than 5% usages
                if (item.usagePresent > 0.05) {
                    Text(
                        text = "${(item.usagePresent * 100).roundToInt()}%",
                        fontSize = 12.sp, color = Color.DarkGray
                    )
                }
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
fun UsageByCategoryPreview() {
    UsageByCategory()
}