package com.chico.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }


    @Composable
    fun Content() {
        val scaffoldState =
            rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    elevation = 4.dp,
                    title = {
                        Text(
                            text = "I'm a TopAppBar",
                            color = Color.Yellow
                        )
                    },
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    navigationIcon = {
                        IconButton(onClick = {
                            Toast.makeText(this@MainActivity, "点击ArrowBack", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            Toast.makeText(this@MainActivity, "点击Share", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(Icons.Filled.Share, null)
                        }
                        IconButton(onClick = {
                            Toast.makeText(this@MainActivity, "点击设置", Toast.LENGTH_SHORT).show()
                        }) {
                            Icon(Icons.Filled.Settings, null)
                        }
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Text(text = "X")
                }
            },
            drawerContent = { Text(text = "DrawerContent") },
            content = { Text(text = "BodyContent") },
            bottomBar = {
                BottomAppBar(backgroundColor = Color.Red) {
                    Text("BottomAppBar")
                }
            }
        )
    }
}