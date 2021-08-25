package com.testsample.ru.component.home

import android.util.Log
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
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.testsample.ru.navigation.*
import com.testsample.ru.ui.theme.SampleForArcticAppTheme

class HomeScreenFactory(private val paddingValues: PaddingValues) : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.HomeScreen.route) {
            HomeComponent(
                navigateTo = { navController.navigateSafe(NavRoute.LIST_ROUTE) }
               // navigateTo = { navController.navigateSafe(NavRoute.OTHER_ROUTE) }
               // navigateTo = { navController.navigateSafe(NavRoute.PAYWALL_ROUTE) }
            )
        }
    }

}

@Composable
fun HomeComponent(navigateTo: () -> Unit) {
    val viewModel = hiltViewModel<HomeViewModel>()

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                navigateTo.invoke()
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Go to list",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "HOME", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-49", "---HomeComponent---")
    }
}

@Preview
@Composable
fun HomePreview() {
    SampleForArcticAppTheme {
        HomeComponent {

        }
    }
}