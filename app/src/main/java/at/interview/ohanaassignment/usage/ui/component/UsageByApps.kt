package at.interview.ohanaassignment.usage.ui.component

import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.interview.ohanaassignment.usage.domain.model.AppUsage
import coil.compose.rememberAsyncImagePainter


@Composable
fun AppUsageItem(modifier: Modifier = Modifier, item: AppUsage) {

    Row(modifier = modifier) {

        Image(
            painter = rememberAsyncImagePainter(model = item.logoUrl),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 4.dp)
                .clip(RoundedCornerShape(8.dp))
                .size(36.dp),
        )

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(text = item.name)
            UsageProgressBar(progress = item.usagePresent, duration = item.duration)
        }
    }
}

@Composable
fun UsageProgressBar(progress: Float, duration: String, height: Dp = 16.dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .weight(progress)
                .fillMaxWidth()
                .height(height)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Blue)
        )

        Spacer(modifier = Modifier.size(4.dp))

        Box(
            modifier = Modifier
                .weight(1 - progress)
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        ) {
            Text(text = duration, color = Color.DarkGray, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppUsagePreview() {

}