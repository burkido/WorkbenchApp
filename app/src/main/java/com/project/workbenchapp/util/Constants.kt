package com.project.workbenchapp.util


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

    object Preferences {
        const val PREFERENCES_NAME = "workbench_preferences"
        const val PREFERENCES_KEY = "on_boarding_completed"
    }

    object Pages {
        const val LAST_ON_BOARDING_PAGE = 2
        const val ITEMS_COUNT_PER_PAGE = 3
    }

    object Retrofit {
        const val BASE_URL = "http://10.0.2.2:8080"
    }

}