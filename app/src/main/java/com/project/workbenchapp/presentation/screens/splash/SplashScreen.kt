package com.project.workbenchapp.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.project.workbenchapp.R
import com.project.workbenchapp.navigation.Screen
import com.project.workbenchapp.ui.theme.Purple500
import com.project.workbenchapp.ui.theme.Purple700

@ExperimentalPagerApi
@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel(),
) {

    val isOnBoardingCompleted by splashViewModel.isOnBoardingCompleted.collectAsState()
    val rotateDegree = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        rotateDegree.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navHostController.popBackStack()
        if (isOnBoardingCompleted)
            navHostController.navigate(Screen.Home.route)
        else
            navHostController.navigate(Screen.Welcome.route)
    }

    Splash(rotateDegree.value)
}

@Composable
fun Splash(rotateDegree: Float) {
    if (isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(rotateDegree),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(id = R.string.logo)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(Brush.verticalGradient(listOf(Purple700, Purple500)))
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(rotateDegree),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(id = R.string.logo)
            )
        }

    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    Splash(rotateDegree = 0f)
}