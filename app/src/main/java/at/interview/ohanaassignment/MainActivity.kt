package at.interview.ohanaassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import at.interview.ohanaassignment.ui.theme.OhanaAssignmentTheme
import at.interview.ohanaassignment.usage.ui.screen.UsageScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OhanaAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    UsageScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UsagePreview() {
    OhanaAssignmentTheme {
        UsageScreen()
    }
}