package com.example.composetext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetext.ui.theme.ComposeTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTextTheme {
//                newAge(age = 30, name = "matr1x")
                ColumnSample() //список похожий на recylerview
                listStart() //список
            }
        }
    }
}

@Composable
fun listStart(){
    val colorNamesList = listOf("Red", "Green", "Blue", "Indigo")

    LazyColumn{
        itemsIndexed(colorNamesList) { index, item ->
            Text(text = "color + $colorNamesList",
                color = Color.Yellow,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(Color.Black)
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        }
    }
}

@Preview()
@Composable
fun ColumnSample() {
    val scroll = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .verticalScroll(scroll)
            .padding(PaddingValues(top = 150.dp))
            .fillMaxSize()
            .background(Color.Transparent),
    ) {
        repeat(25) { position ->

            println("Build item at position print $position")
            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.9f)
                    .height(36.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(Color.LightGray)
                    .clickable {
                        println("@@@ click $position")
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Composable
fun newAge(age: Int, name: String) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Age == $age + name == $name",
            color = Color.Yellow,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Black)
                .wrapContentHeight(Alignment.CenterVertically)
        )
    }

}