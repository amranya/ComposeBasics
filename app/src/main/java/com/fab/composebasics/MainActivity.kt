package com.fab.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fab.composebasics.composables.ImageCard
import com.fab.composebasics.composables.NamesAdder
import com.fab.composebasics.composables.UserGreeter
import com.fab.composebasics.ui.theme.ComposeBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    //ImageCard(imageResourceId = R.drawable.kermit_in_snow, title = "Hello kermit")
    //NamesAdder()
    UserGreeter()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        Screen()
    }
}