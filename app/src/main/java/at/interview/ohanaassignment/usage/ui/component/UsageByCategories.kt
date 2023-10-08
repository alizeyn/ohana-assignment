package at.interview.ohanaassignment.usage.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.interview.ohanaassignment.usage.domain.model.CategoryUsage
import kotlin.math.roundToInt


@Composable
fun CategoryUsageItem(modifier: Modifier = Modifier, item: CategoryUsage) {

    Box(modifier = modifier) {
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

}