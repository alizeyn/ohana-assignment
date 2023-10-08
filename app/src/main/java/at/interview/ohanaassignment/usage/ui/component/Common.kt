package at.interview.ohanaassignment.usage.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Separator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
    )
}

@Composable
fun RoundedCornerIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
            .size(36.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Image(imageVector = icon, contentDescription = null)
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