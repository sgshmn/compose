package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}


// 3D61C0
@Composable
fun BusinessCardApp() {
    Surface(color = Color(0xFF3D61C0)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ImageName(image = painterResource(R.drawable.ic_baseline_android_128), name = "yyw")

        }
    }
}

@Composable
fun ImageName(image: Painter, name: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = image, contentDescription = null)
        Text(
            text = name,
            fontSize = 36.sp,
            modifier = Modifier.padding(bottom = 100.dp),
            color = Color.Black
        )
        PhoneEmailGit()
    }

}

@Composable
fun PhoneEmailGit() {
    Column() {
        PEGText(
            image = painterResource(R.drawable.ic_baseline_smartphone_48),
            content = "+82 010-9992-0996"
        )
        PEGText(
            image = painterResource(R.drawable.ic_baseline_email_48),
            content = "woong0997@gmail.com"
        )
        PEGText(
            image = painterResource(R.drawable.ic_local_github),
            content = "https://github.com/sgshmn"
        )
    }
}

@Composable
fun PEGText(image: Painter, content: String, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = image, contentDescription = null)
        Text(
            text = content,
            modifier = Modifier.padding(start = 24.dp),
            color = Color.Black,
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}