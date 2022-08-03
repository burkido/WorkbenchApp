package com.project.workbenchapp.navigation

import com.project.workbenchapp.util.Constants


sealed class Screen(val route: String) {
    object Splash : Screen(Constants.Screens.SPLASH_SCREEN)
    object Welcome : Screen(Constants.Screens.WELCOME)
    object Home : Screen(Constants.Screens.HOME)
    object Search : Screen(Constants.Screens.SEARCH)
    object Details : Screen(Constants.Screens.DETAILS_WITH_HERO_ID) {
        fun passHeroId(heroId: String) =
            "details_screen/$heroId"
    }
}