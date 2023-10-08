package at.interview.ohanaassignment.usage.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.interview.ohanaassignment.usage.domain.Usage


@Composable
fun UsageSpectrum(modifier: Modifier = Modifier, usages: List<Usage>) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(16.dp)
            .background(Color.LightGray)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            usages.forEach { usage ->
                Box(
                    modifier = Modifier
                        .weight(usage.present)
                        .fillMaxHeight()
                        .background(usage.color)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsageSpectrumPreview() {
    UsageSpectrum(
        usages = listOf(
            Usage(present = 0.5f, color = Color.Red),
            Usage(present = 0.2f, color = Color.Blue),
            Usage(present = 0.1f, color = Color.Green),
        )
    )
}