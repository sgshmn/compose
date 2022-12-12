package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    TextAndImage()
}

@Composable
fun TextAndImage(
    modifier: Modifier = Modifier
) {
    var page by remember { mutableStateOf(0) }

    var sqzCnt by remember { mutableStateOf(0) }

    val text = when(page) {
        0 -> R.string.select_lemon_sentence
        1 -> R.string.squeeze_lemon_sentence
        2 -> R.string.drink_lemon_sentence
        else -> R.string.restart_sentence
    }

    val image = when(page) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val decs = when(page) {
        0 -> R.string.lemon_tree
        1 -> R.string.lemon
        2 -> R.string.glass_of_lemonade
        else -> R.string.empty_glass
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(text),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.border(border = BorderStroke(
                color = Color(red = 105, green = 205, blue = 216),
                width = 4.dp),
                shape = RoundedCornerShape(10.dp)
            )
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(decs),
                modifier = Modifier.clickable {
                    when(page) {
                        0 -> {
                            page = 1
                            sqzCnt = (2..4).random()
                        }
                        1 -> {
                            sqzCnt--
                            if (sqzCnt == 0) {
                               page = 2
                            }
                        }
                        2 -> page = 3
                        else -> page = 0
                    }
                }
            )
        }
    }
}