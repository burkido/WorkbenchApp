package com.project.workbenchapp.presentation.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import com.project.workbenchapp.R
import com.project.workbenchapp.domain.model.OnBoardingPage
import com.project.workbenchapp.ui.theme.*
import com.project.workbenchapp.util.Constants.Pages.LAST_ON_BOARDING_PAGE

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun WelcomeScreen(navController: NavHostController) {

    val pages = listOf(
        OnBoardingPage.FirstScreen,
        OnBoardingPage.SecondScreen,
        OnBoardingPage.ThirdScreen,
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.backgroundColorBySystem)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = pages.size,
            verticalAlignment = Alignment.Top
        ) { pageIndex ->
            PagerScreen(onBoardingPage = pages[pageIndex])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeIndicateColor,
            inactiveColor = MaterialTheme.colors.inActiveIndicateColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING
        )
        FinishButton(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
        ) {

        }

    }
}


@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
) {

    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }

}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.imageId),
            contentDescription = stringResource(id = R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstOnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.FirstScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun SecondOnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.SecondScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdOnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.ThirdScreen)
    }
}
