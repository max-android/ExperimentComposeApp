package com.testsample.ru.component

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
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.testsample.ru.navigation.ComposeNavFactory
import com.testsample.ru.navigation.NavRoute
import com.testsample.ru.navigation.Screen
import com.testsample.ru.navigation.navigateSafe
import com.testsample.ru.ui.theme.SampleForArcticAppTheme
import com.testsample.ru.utils.EMPTY_VALUE
import com.testsample.ru.utils.INNER_OTHER

class OtherScreenFactory(private val paddingValues: PaddingValues): ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.OtherScreen.route) {
            OtherComponent(
                navigateTo = {
                    navController.navigateSafe("${Screen.PaywallScreen.route}/$INNER_OTHER")
                }
            )
        }
    }

}

@Composable
fun OtherComponent(navigateTo: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            navigateTo.invoke()
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Text(
                text = "Go to paywall",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "OTHER", modifier = Modifier.fillMaxSize())
    }
    Log.i("--INIT-44", "---OtherComponent---")
}

@Preview
@Composable
fun OtherPreview() {
    SampleForArcticAppTheme {
        OtherComponent {}
    }
}