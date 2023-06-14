package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val name = remember { mutableStateOf("") }
            // val surname by remember { mutableStateOf("") }
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name.value)
                }
            }
        }
    }
}

/*fun changeName(name: MutableState<String>) {
    name.value = "Nuevo Texto"
}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // val scrollState = rememberScrollState()
    var value by remember { mutableStateOf(TextFieldValue("")) }
    var isError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.size(150.dp))

            TextField(
                value = value,
                onValueChange = {
                    if (it.text.contains("h") || it.text.isNotEmpty()) {
                        value = it
                        isError = false
                    } else {
                        isError = true
                    }
                },
                isError = isError,
                label = {
                    Text("Email")
                }
                /*trailingIcon = {
                    Image(
                        modifier = Modifier.size(80.dp),
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                    )
                }*/
            )

            Spacer(modifier = Modifier.size(30.dp))

            TextField(
                value = value,
                onValueChange = {
                    if (it.text.contains("h") || it.text.isNotEmpty()) {
                        value = it
                        isError = false
                    } else {
                        isError = true
                    }
                },
                isError = isError,
                label = {
                    Text("Password")
                }
            )

            Spacer(modifier = Modifier.size(20.dp))

            Button(onClick =  {
                value = TextFieldValue(value.text + "1")
            }) {
                Text(text = "LOGIN")
            }

            Spacer(modifier = Modifier.size(30.dp))

            Button(onClick =  {
                value = TextFieldValue(value.text + "1")
            }) {
                Text(text = "SINGIN")
            }

            Button(onClick =  {
                value = TextFieldValue(value.text + "1")
            }) {
                Text(text = "RECOVER PASSWORD")
            }
        }

        /*LazyColumn(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (i in 1..100) {
                item {
                    Text(
                        text = "Hello $name! nº$i",
                        modifier = modifier
                    )
                }
            }
        }*/
    }
}

@Preview(
    showBackground = true,
    heightDp = 800,
    widthDp = 400
)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("Android")
    }
}