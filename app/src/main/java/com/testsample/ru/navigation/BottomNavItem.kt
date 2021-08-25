package com.testsample.ru.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.testsample.ru.R

data class BottomNavItem(
    val screen: Screen,
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
)

val bottomNavItems = listOf(
    BottomNavItem(
        screen = Screen.HomeScreen,
        titleResId = R.string.home,
        drawableResId = R.drawable.ic_home
    ),
    BottomNavItem(
        screen = Screen.OtherScreen,
        titleResId = R.string.other,
        drawableResId = R.drawable.ic_other
    ),
    BottomNavItem(
        screen = Screen.ProfileScreen,
        titleResId = R.string.profile,
        drawableResId = R.drawable.ic_profile
    )
)

