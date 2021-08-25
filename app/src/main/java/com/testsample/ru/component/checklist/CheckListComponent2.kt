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

class CheckListScreen2Factory(private val paddingValues: PaddingValues) : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.CheckList2.route) {

            val viewModel = hiltViewModel<CheckListViewModel>()

            CheckListComponent2(
                navigateTo = {
                    viewModel.setStep(STEP_3)
                    navController.navigateSafe(
                        Screen.CheckList3.route,
                        NavOptions.Builder().setPopUpTo(Screen.CheckList2.route, true)
                            .setBaseAnim()
                    )
                },
                onBackPressed = {
                    viewModel.setStep(STEP_1)
                    navController.navigateSafe(
                        Screen.CheckList1.route,
                        NavOptions.Builder().setPopUpTo(Screen.CheckList2.route, true)
                            .setBaseAnim()
                    )
                }
            )
        }
    }

}

@Composable
fun CheckListComponent2(navigateTo: () -> Unit, onBackPressed: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            navigateTo.invoke()
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Text(
                text = "Go to screen-3",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(onClick = {
            onBackPressed.invoke()
        }, modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Text(
                text = "Back to screen-1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "CHECKLIST-2", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-54", "---CheckListComponent2---")
    }
}

@Preview
@Composable
fun CheckList2Preview() {
    SampleForArcticAppTheme {
        CheckListComponent2(
            navigateTo = { },
            onBackPressed = { }
        )
    }
}