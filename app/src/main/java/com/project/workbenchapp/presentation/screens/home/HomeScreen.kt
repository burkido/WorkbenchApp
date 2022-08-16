package com.project.workbenchapp.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {

        }
    }

}