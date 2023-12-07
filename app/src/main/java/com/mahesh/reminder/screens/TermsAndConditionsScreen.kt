package com.mahesh.reminder.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahesh.reminder.R
import com.mahesh.reminder.components.HeadingTextComponent
import com.mahesh.reminder.components.NormalTextComponent
import com.mahesh.reminder.navigation.AppRouter
import com.mahesh.reminder.navigation.Screen
import com.mahesh.reminder.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {
        HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
    }

    Spacer(modifier = Modifier.height(10.dp))

    NormalTextComponent(value = stringResource(id = R.string.terms_and_conditions_headerdes))
    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionsScreenPreview(){
    TermsAndConditionsScreen()
}