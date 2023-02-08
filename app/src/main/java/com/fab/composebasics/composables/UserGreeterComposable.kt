package com.fab.composebasics.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun UserGreeter() {
    val scaffoldState = rememberScaffoldState()
    var textValue by remember {
        mutableStateOf("")
    }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(modifier = Modifier.fillMaxSize(),
    scaffoldState = scaffoldState,
    content = {
        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            TextField(value = textValue, onValueChange = {
                textValue = it
            },
                label = {
                    Text(text = "Enter your name")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello $textValue")
                }
            }) {
                Text(text = "Greet me")
            }
        }
    })
}