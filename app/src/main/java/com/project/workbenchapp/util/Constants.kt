package com.project.workbenchapp.util

import com.project.workbenchapp.data.local.WorkbenchDatabase

object Constants {

    object Screens {
        const val SPLASH_SCREEN = "splash_screen"
        const val WELCOME = "welcome"
        const val HOME = "home"
        const val SEARCH = "search_screen"
        const val DETAILS_WITH_HERO_ID = "details_screen/{heroId}"
        const val DETAILS_ARGUMENT_KEY = "heroId"
    }

    object Database {
        const val WORKBENCH_DATABASE = "workbench_database"
        const val HERO_TABLE = "hero_table"
        const val HERO_REMOTE_KEY_TABLE = "hero_remote_key_table"
    }

    object Pages {
        const val LAST_ON_BOARDING_PAGE = 2
    }

}