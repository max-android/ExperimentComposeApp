package com.testsample.ru.navigation

sealed class Screen(val route: String) {
    object CheckList1: Screen(NavRoute.CHECKLIST_1_ROUTE)
    object CheckList2: Screen(NavRoute.CHECKLIST_2_ROUTE)
    object CheckList3: Screen(NavRoute.CHECKLIST_3_ROUTE)
    object HomeScreen: Screen(NavRoute.HOME_ROUTE)
    object OtherScreen: Screen(NavRoute.OTHER_ROUTE)
    object ProfileScreen: Screen(NavRoute.PROFILE_ROUTE)
    object PaywallScreen: Screen(NavRoute.PAYWALL_ROUTE)
    object ListScreen: Screen(NavRoute.LIST_ROUTE)
    object DetailScreen: Screen(NavRoute.DETAIL_ROUTE)
    object SettingsScreen: Screen(NavRoute.SETTINGS_ROUTE)
}