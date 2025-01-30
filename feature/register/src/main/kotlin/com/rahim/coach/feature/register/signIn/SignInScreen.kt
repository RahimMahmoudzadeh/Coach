package com.rahim.coach.feature.register.signIn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahim.coach.feature.register.R
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.base.SizeDimensions

@Composable
internal fun SignInRoute() {
    SignInScreen()
}

@Composable
private fun SignInScreen() {
    val size = LocalSize.current
    val space = LocalSpacing.current
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .padding(top = space.large, start = space.large)
                    .size(size.extraExtraExtraLarge),
                imageVector = ImageVector.vectorResource(R.drawable.ic_back_arrow_green),
                contentDescription = "back image"
            )
            Image(
                modifier = Modifier.size(width = 72.dp, height = 87.dp),
                imageVector = ImageVector.vectorResource(com.rahim.coach.library.designsystem.R.drawable.ic_app_icon),
                contentDescription = "app logo",

                )
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    MaterialTheme {
        SignInRoute()
    }
}