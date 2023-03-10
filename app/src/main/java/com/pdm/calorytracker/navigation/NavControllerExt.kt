package com.pdm.calorytracker.navigation

import androidx.navigation.NavController
import com.pdm.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}