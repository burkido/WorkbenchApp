package com.project.workbenchapp.domain.model

import androidx.annotation.DrawableRes
import com.project.workbenchapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val imageId: Int,
    val title: String,
    val description: String
) {

    object FirstScreen : OnBoardingPage(
        imageId = R.drawable.greetings,
        title = "Greetings",
        description = "Lorem ipsum bla bla bla greetings"
    )

    object SecondScreen : OnBoardingPage(
        imageId = R.drawable.explore,
        title = "Explore",
        description = "Lorem ipsum bla bla bla explore"
    )

    object ThirdScreen : OnBoardingPage(
        imageId = R.drawable.power,
        title = "Power",
        description = "Lorem ipsum bla bla bla power"
    )
    
}
