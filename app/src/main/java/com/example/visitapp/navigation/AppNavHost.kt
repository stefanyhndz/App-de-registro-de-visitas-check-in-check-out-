package com.example.visitapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.visitapp.ui.MainScreen
import com.example.visitapp.ui.HistoryScreen
import com.example.visitapp.ui.VisitsViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    viewModel: VisitsViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.HOME
    ) {

        composable(NavRoutes.HOME) {
            MainScreen(
                viewModel = viewModel,
                onGoToHistory = { navController.navigate(NavRoutes.HISTORY) }
            )
        }

        composable(NavRoutes.HISTORY) {
            HistoryScreen(
                visits = viewModel.uiState.value.visits,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
