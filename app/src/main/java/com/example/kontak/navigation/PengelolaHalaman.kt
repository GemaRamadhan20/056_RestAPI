package com.example.kontak.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kontak.ui.home.screen.DestinasiEntry
import com.example.kontak.ui.home.screen.DestinasiHome
import com.example.kontak.ui.home.screen.DetailsDestination
import com.example.kontak.ui.home.screen.DetailsScreen
import com.example.kontak.ui.home.screen.EntryKontakScreen
import com.example.kontak.ui.home.screen.HomeScreen


@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = {})
        }
        composable(DestinasiEntry.route) {
            EntryKontakScreen(
                navigateBack = {
                    navController.navigate(DestinasiHome.route) {
                        popUpTo(
                            DestinasiHome.route
                        ) { inclusive = true }
                    }
                },
            )
        }
        composable(
            DetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailsDestination.kontakId) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt(DetailsDestination.kontakId)
            itemId?.let {
                DetailsScreen(
                    navigateBack = {
                        navController.navigateUp()
                    },
                    onEditClick = {}

                )
            }
        }
    }
}

