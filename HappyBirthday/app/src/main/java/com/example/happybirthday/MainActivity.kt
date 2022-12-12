package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(message = "Happy Birthday yyw!", from = "- from Emma")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {

    // UI 계층 구조

    // 상위 UI가 하위 UI를 포함하는 것
    // 행, 열, 상자 컴포저블이 상위 UI가 될 수 있다
        // Column, Row, Box
        // 컴포저블 콘텐츠를 인수로 사용하는 구성 가능한 함수
        // 레이아웃 요소에 항목을 배치할 수 있다


    // 후행 람다 문법
    // 소괄호를 안 쓰고 바로 중괄호를 사용하는 것
    // 코틀린은 마지막 매개변수가 함수일 때
    // 함수를 매개변수로 함수에 전달하는 특수한 문법을 제공한다
    // 함수를 괄호 안에 함수이름과 함께 넣는 대신 함수 이름 뒤 중괄호에 넣는다

//    Row(
//        content = {
//            Text("Some text")
//            Text("Some more text")
//            Text("Last text")
//        }
//    )

//    Row {
//        Text("Some text")
//        Text("Some more text")
//        Text("Last text")
//    }

    // 위와 아래는 결과가 같다
    // content가 Row() 함수의 마지막 매개변수인데 중괄호를 쓰면
    // 마지막 매개변수가 중괄호 안의 내용으로 들어간다


    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from:String) {
    val image = painterResource(R.drawable.androidparty)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}


@Preview(showBackground = true)
@Composable
fun HappyBirthdayPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(message = stringResource(R.string.happy_birthday_text), stringResource(
                    R.string.signature_text)
                )
    }
}


// 사용자 인터페이스 UI

// 화면에 표시하는 글, 그림, 버튼, 기타 여러 유형의 요소와 그 요소를 화면에 표시하는 방식
// 앱이 내용을 사용자에게 보여주는 방식
// 사용자가 앱과 상호작용하는 방식

// 누를 수 있는 버튼, 텍스트 메시지, 텍스트 입력칸 등
// 각각의 요소를 UI 구성요소라고 한다
// 앱 화면에 표시되는 대부분의 내용은 UI 요소(UI 구성소요)다
// 상호작용이 가능할 수도 있고, 그냥 장식일 수도 있다


// Jetpack Compose

// 안드로이드 UI 빌드하기 위해 사용하는 최신 툴킷
// 코드가 짧다
// 강력하다(왜?)
// 코틀린 기능이 직관적이다
// 위 장점으로 UI 개발을 간소화 한다
// 데이터를 받아서 UI요소를 내보내는 함수집합을 정의해서 UI를 빌드한다(구성 가능한 함수, Composable 함수)


// 구성가능한 함수

// UI일부를 설명한다
// 매개변수를 허용하여 앱 로직이 UI를 성명하거나 수정할 수 있게한다
// Greeting함수에는 String을 허용해서 사용자게에게 이름으로 인사할 수 있다
// 아무것도 반환하지 않는다
// 원하는 화면 상태를 기술 할 뿐이다
// UI를 만들지는 않기 때문이다
// 여러 UI 요소를 내보낼 수 있다
// @Composable 주석이 있어한다
// 이 주석을 통해 이 함수가 데이터를 UI로 변환하게 되어 있다는 것을 Compose 컴파일러에 알린다


// 주석 @

// 코드에 추가 정보를 첨부하는 방법
// Jetpack Compose 컴파일러 같은 도구가 앱의 코드를 이해하는 데 도움이 된다
// 개발자에게도 도움 된다
// @ 을 접두사로 추가해서 적용한다
// 속성, 함수, 클래스 등 다양한 코드 요소에 주석을 달 수 있다
// 주석은 매개변수를 받을 수 있다
// @Preview(showBackground = true) 배경을 미리 보여주는 주석(true 흰색, false 검은색)
// @Preview(name = "My Preview") 미리보기 제목


// 구성 가능한 함수 이름 규칙

// 파스칼 표기법
    // 복합어에서 각 단어의 첫글자를 모두 대문자로 표기
// 명사이어야한다 : DoneButton() O
// 동사 또는 동사구는 안 된다 : DrawTextField() X
// 명사화된 전치사는 안 된다 : TextFieldWithLink() X
// 형용사는 안 된다 : Bright() X
// 명사 앞에는 명사를 설명하는 형용사를 붙일 수 있다 : RoundIcon() O
