package com.kelvin.catalog.shared

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kelvin.catalog.home.HomeScreen
import com.kelvin.catalog.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Splash.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
//        composable(
//            NavigationItem.UserDetail.route + "/{id}", arguments = listOf(
//            navArgument("id") {
//                type = NavType.IntType
//                defaultValue = 0
//            }
//        )) {
//            val id = it.arguments?.getInt("id") ?: 0
//            UserDetailScreen(id = id)
//        }
    }
}
