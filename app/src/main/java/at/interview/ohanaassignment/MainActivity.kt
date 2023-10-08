package at.interview.ohanaassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.usage.ui.Separator
import at.interview.ohanaassignment.usage.ui.Usage

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
            WeekNavigationBar(modifier)
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
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            TextButton(onClick = { }) {
                NavigateButton(icon = Icons.Rounded.ArrowBack)
            }
        }

        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(text = "This Week")
        }

        Box(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            TextButton(onClick = { }) {
                NavigateButton(icon = Icons.Rounded.ArrowForward)
            }
        }
    }
}

@Composable
fun NavigateButton(
    modifier: Modifier = Modifier,
    icon: ImageVector
) {
    Card(
        modifier = modifier
            .border(1.dp, Color.DarkGray, RoundedCornerShape(4.dp))
            .padding(8.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.wrapContentHeight()
        ) {
            Icon(imageVector = icon, contentDescription = null)
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