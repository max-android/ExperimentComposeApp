package com.testsample.ru.component.main

import android.graphics.Color
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.testsample.ru.component.*
import com.testsample.ru.component.checklist.CheckListScreen1Factory
import com.testsample.ru.component.checklist.CheckListScreen2Factory
import com.testsample.ru.component.checklist.CheckListScreen3Factory
import com.testsample.ru.component.detail.DetailScreenFactory
import com.testsample.ru.component.home.HomeScreenFactory
import com.testsample.ru.component.list.ListScreenFactory
import com.testsample.ru.navigation.*
import com.testsample.ru.ui.theme.Purple700

//см.
//https://developer.android.com/jetpack/compose/navigation#nav-to-composable

//import androidx.compose.runtime.*
//используется для переходов назад через экран
////navController.popBackStack(Screen.Adopt, inclusive = true)

@Composable
fun MainComponent() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val viewModel = hiltViewModel<MainViewModel>()

    Scaffold(
        bottomBar = {
            val currentDestination = navBackStackEntry?.destination
           // val isVisBottom = isNeedShowBottomBar(navBackStackEntry)
            val isVisBottom = false
            Log.i("--BAR-50", "--------"+isVisBottom)
            if (isVisBottom) {
                BottomNavigation {
                    bottomNavItems.forEachIndexed { index, tabBarItem ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = tabBarItem.drawableResId),
                                    contentDescription = null,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            label = { Text(stringResource(tabBarItem.titleResId)) },
                            selected = currentDestination?.hierarchy?.any {
                                it.route == tabBarItem.screen.route ||
                                        it.route == Screen.DetailScreen.route && index == 0 ||
                                        it.route == Screen.ListScreen.route && index == 0 ||
                                        it.route == Screen.SettingsScreen.route && index == 2
                            } == true,
                            unselectedContentColor = Purple700.copy(alpha = 0.5f),
                            onClick = {
                                //для случая, когда надо перейдти на Paywall по нажатию на элемент нижнего меню
//                                if (viewModel.isPaywall() && index == 1) {
//                                    //navController.navigateSafe(Screen.PaywallScreen.route)
//                                    navController.navigateSafe("${Screen.PaywallScreen.route}/${NavRoute.OTHER_ROUTE}")
//                                    return@BottomNavigationItem
//                                }
                                navController.navigateSafeWithBuilder(tabBarItem.screen.route) {
//                                        // Pop up to the start destination of the graph to
//                                        // avoid building up a large stack of destinations
//                                        // on the back stack as users select items
//                                        popUpTo(navController.graph.findStartDestination().id) {
//                                            saveState = true
//                                        }
                                    popUpTo(Screen.HomeScreen.route) {
                                        saveState = true
                                    }

//                                        // Avoid multiple copies of the same destination when
//                                        // reselecting the same item
                                    launchSingleTop = true

                                    // Restore state when reselecting a previously selected item
                                    // restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        },
        content = { paddingValue ->
            NavHost(navController = navController, startDestination = viewModel.currentScreen()) {
                CheckListScreen1Factory(paddingValue).create(this, navController)
                CheckListScreen2Factory(paddingValue).create(this, navController)
                CheckListScreen3Factory(paddingValue).create(this, navController)
                HomeScreenFactory(paddingValue).create(this, navController)
                OtherScreenFactory(paddingValue).create(this, navController)
                ProfileScreenFactory(paddingValue).create(this, navController)
                PaywallScreenFactory(paddingValue).create(this, navController)
                ListScreenFactory(paddingValue).create(this, navController)
                DetailScreenFactory(paddingValue).create(this, navController)
                SettingsScreenFactory(paddingValue).create(this, navController)
            }
        }
    )

}

private fun isNeedShowBottomBar(navBackStackEntry: NavBackStackEntry?): Boolean {
    val currentDestination = navBackStackEntry?.destination?.route
    Log.i("--BAR-122", "--------"+currentDestination)
    if (currentDestination != null) {
        return currentDestination.contains(Screen.HomeScreen.route) ||
                currentDestination.contains(Screen.OtherScreen.route) ||
                currentDestination.contains(Screen.ProfileScreen.route) ||
                currentDestination.contains(Screen.ListScreen.route) ||
                currentDestination.contains(Screen.DetailScreen.route) ||
                currentDestination.contains(Screen.SettingsScreen.route)
    }
    return false
}

private fun transitionIfPaywall(mainViewModel: MainViewModel) {
     if (mainViewModel.isPaywall()) {

     }
}