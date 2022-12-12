package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Explains()
                }
            }
        }
    }
}

@Composable
fun Explains() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Explain(
                title = stringResource(R.string.title1),
                content = stringResource(R.string.content1),
                c = Color.Green,
                modifier = Modifier.weight(1f)
            )
            Explain(
                title = stringResource(R.string.title2),
                content = stringResource(R.string.content2),
                c = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Explain(
                title = stringResource(R.string.title3),
                content = stringResource(R.string.content3),
                c = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            Explain(
                title = stringResource(R.string.title4),
                content = stringResource(R.string.content4),
                c = Color.Gray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Explain(
    title: String,
    content: String,
    c: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(c)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        Explains()
    }
}