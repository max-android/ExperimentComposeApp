package com.testsample.ru.component.checklist

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.testsample.ru.R

class CheckListScreen1Factory(private val paddingValues: PaddingValues) : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(Screen.CheckList1.route) {

            val viewModel = hiltViewModel<CheckListViewModel>()

            CheckListComponent1(
                navigateTo = {
                    viewModel.setStep(STEP_2)
                    navController.navigateSafe(
                        Screen.CheckList2.route,
                        NavOptions.Builder()
                            //.setLaunchSingleTop(true)
                            .setPopUpTo(Screen.CheckList1.route, true).setBaseAnim()
                    )
                }
            )
        }
    }

}

@Composable
fun CheckListComponent1(
    navigateTo: () -> Unit
) {
    CheckList(
        stringResource(id = R.string.title_1),
        listOf(
            ListModel(
                stringResource(id = R.string.competence),
                R.drawable.ic_screen_1_1
            ),
            ListModel(
                stringResource(id = R.string.attitude),
                R.drawable.ic_screen_1_2
            ),
            ListModel(
                stringResource(id = R.string.achievement),
                R.drawable.ic_screen_1_3
            ),
            ListModel(
                stringResource(id = R.string.creative),
                R.drawable.ic_screen_1_4
            ),
            ListModel(
                stringResource(id = R.string.physiological),
                R.drawable.ic_screen_1_5
            ),
            ListModel(
                stringResource(id = R.string.social),
                R.drawable.ic_screen_1_6
            ),
            ListModel(
                stringResource(id = R.string.fear),
                R.drawable.ic_screen_1_7
            ),
            ListModel(
                stringResource(id = R.string.power),
                R.drawable.ic_screen_1_8
            ),
            ListModel(
                stringResource(id = R.string.success),
                R.drawable.ic_screen_1_9
            )
        ),
        navigateTo
    )

//    Column(modifier = Modifier.fillMaxSize()) {
//        Button(onClick = {
//            navigateTo()
//        }, modifier = Modifier
//            .padding(4.dp)
//            .fillMaxWidth()) {
//            Text(
//                text = "Go to screen-2",
//                style = TextStyle(fontSize = 20.sp)
//            )
//        }
//        Text(text = "CHECKLIST-1", modifier = Modifier.fillMaxSize())
//        Log.i("--INIT-60", "---CheckListComponent1---")
//    }
}

@Preview
@Composable
fun CheckList1Preview() {
    SampleForArcticAppTheme {
        CheckListComponent1 {}
    }
}