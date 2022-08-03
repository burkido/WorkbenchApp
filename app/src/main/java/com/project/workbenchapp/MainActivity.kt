package com.project.workbenchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.project.workbenchapp.navigation.SetupNavGraph
import com.project.workbenchapp.ui.theme.WorkbenchAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkbenchAppTheme {

                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

