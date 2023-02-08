package com.fab.composebasics.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NamesAdder() {
    var name by remember {
        mutableStateOf("")
    }
    var nameList by remember {
        mutableStateOf(emptyList<String>())
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = name, onValueChange = { text ->
                    name = text
                }, modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        nameList = nameList + name
                        name = ""
                    }
                }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue, contentColor = Color.Red
                )
            ) {
                Text(
                    text = "Add",
                    color = Color.Green,
                    fontSize = 20.sp,

                    )
            }
        }
        NameList(nameList = nameList)
    }
}

@Composable
fun NameList(
    nameList: List<String>
) {
    LazyColumn {
        items(nameList) { currentName ->
            Text(
                text = currentName, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider(
                color = Color.Red
            )
        }
    }
}