package com.testsample.ru.component.detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.testsample.ru.navigation.ComposeNavFactory
import com.testsample.ru.navigation.Screen
import com.testsample.ru.ui.theme.Purple200
import com.testsample.ru.ui.theme.SampleForArcticAppTheme

class DetailScreenFactory(private val paddingValues: PaddingValues): ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.DetailScreen.route) {
            DetailComponent(
                onBackPressed = { navController.popBackStack() }
            )
        }
    }

}

@Composable
fun DetailComponent(onBackPressed: () -> Unit) {
    val viewModel = hiltViewModel<DetailViewModel>()

    Column(modifier = Modifier.fillMaxSize().background(color = Purple200)) {
        Button(onClick = {
            onBackPressed.invoke()
        }, modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Text(
                text = "Go to back list",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "Detail", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-44", "---DetailComponent---")
    }
}

@Preview
@Composable
fun DetailPreview() {
    SampleForArcticAppTheme {
        DetailComponent(
            onBackPressed = { }
        )
    }
}