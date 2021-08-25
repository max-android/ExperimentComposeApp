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
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.testsample.ru.navigation.*
import com.testsample.ru.ui.theme.SampleForArcticAppTheme
import com.testsample.ru.utils.INNER_OTHER

class PaywallScreenFactory(private val paddingValues: PaddingValues) : ComposeNavFactory {

    override fun create(navGraphBuilder: NavGraphBuilder, navController: NavController) {
        navGraphBuilder.composable(
            route = Screen.PaywallScreen.route + "/{${NavArgument.FromScreenArg.key}}",
            arguments = listOf(navArgument(NavArgument.FromScreenArg.key) {
                type = NavType.StringType
            })
        ) { entry ->
            val fromScreen = entry.arguments?.getString(NavArgument.FromScreenArg.key).orEmpty()
            Log.i("--INIT-32", "---fromScreen:"+fromScreen)
            PaywallComponent(
                // onBackPressed = { navController.popBackStack() }
                onBackPressed = {
                    when (fromScreen) {
                        NavRoute.OTHER_ROUTE -> {
                            navController.navigateSafe(
                                Screen.OtherScreen.route,
                                NavOptions.Builder().setPopUpTo(Screen.PaywallScreen.route, true).setBaseAnim()
                            )
                        }
                        NavRoute.PROFILE_ROUTE -> {
                            navController.popBackStack()
                        }
                        INNER_OTHER -> {
                            navController.popBackStack()
                        }
                        else -> {
                            navController.popBackStack()
                        }
                    }
                }
                //переход после оплаты в LIST_ROUTE
//                onBackPressed = {
//                    navController.navigateSafe(
//                        NavRoute.LIST_ROUTE,
//                        NavOptions.Builder().setPopUpTo(NavRoute.PAYWALL_ROUTE, true).build()
//                    )
//                }
            )
        }
    }

}

@Composable
fun PaywallComponent(onBackPressed: () -> Unit) {
    BackHandler {
        Log.i("--INIT-71", "---back---")
        onBackPressed.invoke()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = {
                onBackPressed.invoke()
            }, modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Back to Profile",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Text(text = "Paywall", modifier = Modifier.fillMaxSize())
        Log.i("--INIT-64", "---PaywallComponent---")
    }
}

@Preview
@Composable
fun PaywallPreview() {
    SampleForArcticAppTheme {
        PaywallComponent {

        }
    }
}