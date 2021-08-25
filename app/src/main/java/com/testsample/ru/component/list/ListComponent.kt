package com.testsample.ru.component.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.testsample.ru.navigation.*
import com.testsample.ru.ui.theme.SampleForArcticAppTheme
import com.testsample.ru.ui.theme.Teal200

class ListScreenFactory(private val paddingValues: PaddingValues): ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.ListScreen.route) {
                ListComponent(
                    navigateTo = { navController.navigateSafe(NavRoute.DETAIL_ROUTE) },
                    onBackPressed = { navController.popBackStack() }
                )
        }
    }

}

@Composable
fun ListComponent(navigateTo: () -> Unit, onBackPressed: () -> Unit) {
    val viewModel = hiltViewModel<ListViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Teal200),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navigateTo.invoke()
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Text(
                text = "Go to detail",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Button(onClick = {
            onBackPressed.invoke()
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Text(
                text = "Go to back home",
                style = TextStyle(fontSize = 20.sp)
            )
        }

        Text(text = "LIST", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-73", "---ListComponent---")
    }
}

@Preview
@Composable
fun ListPreview() {
    SampleForArcticAppTheme {
        ListComponent(
            navigateTo = { },
            onBackPressed = { }
        )
    }
}