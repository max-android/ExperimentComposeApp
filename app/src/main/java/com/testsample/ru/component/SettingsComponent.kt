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

class SettingsScreenFactory(private val paddingValues: PaddingValues): ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.SettingsScreen.route) {
            SettingsComponent(
                navigateTo = { navController.popBackStack() }
            )
        }
    }

}

@Composable
fun SettingsComponent(navigateTo: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            navigateTo.invoke()
        }, modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Text(
                text = "Go to back",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "Settings", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-46", "---SettingsComponent---")
    }
}

@Preview
@Composable
fun SettingsPreview() {
    SampleForArcticAppTheme {
        SettingsComponent(
            navigateTo = { }
        )
    }
}