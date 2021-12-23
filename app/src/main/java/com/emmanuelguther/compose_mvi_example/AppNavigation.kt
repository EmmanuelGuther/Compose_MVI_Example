package com.emmanuelguther.compose_mvi_example

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emmanuelguther.features.main.MainScreen
import com.emmanuelguther.features.main.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

sealed class Routes(val path: String) {
    object Main : Routes("main")
}

@ExperimentalCoroutinesApi
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Main.path) {
        mainNavRoute(navController)
    }
}

@ExperimentalCoroutinesApi
@OptIn(ExperimentalComposeUiApi::class)
private fun NavGraphBuilder.mainNavRoute(navController: NavHostController) {
    composable(Routes.Main.path) {
        val viewModel: MainViewModel = hiltViewModel()
        MainScreen(viewModel)
    }
}
