package com.testsample.ru.component.checklist

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

class CheckListScreen3Factory(private val paddingValues: PaddingValues) : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.CheckList3.route) {

            val viewModel = hiltViewModel<CheckListViewModel>()

            CheckListComponent3(
                navigateTo = {
                    viewModel.setStep(STEP_FINAL)
                    navController.navigateSafe(
                        Screen.HomeScreen.route,
                        NavOptions.Builder().setPopUpTo(Screen.CheckList3.route, true)
                            .setBaseAnim()
                    )
                },
                onBackPressed = {
                    viewModel.setStep(STEP_2)
                    navController.navigateSafe(
                        Screen.CheckList2.route,
                        NavOptions.Builder().setPopUpTo(Screen.CheckList3.route, true)
                            .setBaseAnim()
                    )
                }
            )
        }
    }

}

@Composable
fun CheckListComponent3(
    navigateTo: () -> Unit, onBackPressed: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                navigateTo.invoke()
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Go to main",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(
            onClick = {
                onBackPressed.invoke()
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Back to screen-2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "CHECKLIST-3", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-64", "---CheckListComponent3---")
    }
}

@Preview
@Composable
fun CheckList3Preview() {
    SampleForArcticAppTheme {
        CheckListComponent3(
            navigateTo = { },
            onBackPressed = { }
        )
    }
}