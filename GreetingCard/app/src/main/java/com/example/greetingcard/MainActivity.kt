package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color // import 한 것. 알파벳 순서로 바꾸려면 help에서 find action, optimize imports 를 하자
import androidx.compose.ui.tooling.preview.Preview
import com.example.greetingcard.ui.theme.GreetingCardTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import kotlin.properties.ReadWriteProperty

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // onCreate() 함수

        // 이 앱의 진입점
        // 다른 함수를 호출해서 사용자 인터페이스를 빌드한다
        // 일종의 main() 함수 역할
        super.onCreate(savedInstanceState)
        setContent {
            // setContent() 함수

            // 구성 가능한(Composable) 함수를 통해 레이아웃을 정의한다
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("yyw")
                }
            }
        }
    }
}


// 구성 가능한 함수 Composable function

// @Composable 주석으로 표시한 함수
// setContent() 함수나 다른 구성 가능한 함수에서 호출할 수 있다
// @Composable 주석이 있으면 Jetpack Compose에서 이 함수가 사용자 인터페이스를 생성하는데 사용한다고 코틀린 컴파일러에 알린다


@Composable // 구성 가능한 함수 앞에는 이 주석이 있다
fun Greeting(name: String) { // 구성 가능한 함수는 첫 글자를 대문자로 쓴다

    // 소개의 배경 색깔을 바꾸려면 Text를 Surface로 둘러싸야 한다

    // Surface는 배경 새깔이나 테두리 같은 모야을 개발자가 변경할 수 있는
    // UI 공간을 나타내는 컨테이너다


    Surface(color = Color.LightGray) { // Color 처음에 빨간줄, import 해야한다
        Text(text = "Hi, my name is $name!", modifier = Modifier.padding(24.dp))
        // 위 Text()를 블록으로 감싸서 alt enter
        // Surround with widget 선택
        // Surround with Container 선택
        // 처음에는 Box를 준다
        // 다른걸로 바꾸면 됨 지금은 Surface로 바꾸자
    }

    // 구성가능한 함수는 반환값이 없다
}

// DefalutPreview() 함수

// 전체 앱을 빌드하지 않고 앱이 어떻게 표시되는지 확인할 수 있다
// 미리보기 함수에는 @Preview 주석이 있어야 한다
// showBackground = true이면 앱 미리보기에 배경을 추가한다
// true는 흰색, false는 검은색이다
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingCardTheme {
        Greeting("yyw")
    }
}