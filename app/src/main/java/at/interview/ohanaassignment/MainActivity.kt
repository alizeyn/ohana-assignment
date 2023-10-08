package at.interview.ohanaassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.usage.ui.component.RoundedCornerIconButton
import at.interview.ohanaassignment.usage.ui.component.Separator
import at.interview.ohanaassignment.usage.ui.screen.Usage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OhanaAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Usage()
                }
            }
        }
    }
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
        Usage()
    }
}