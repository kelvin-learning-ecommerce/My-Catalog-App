package com.kelvin.catalogue.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kelvin.catalogue.presentation.dashboard.DashboardScreen
import com.kelvin.catalogue.presentation.favorite.FavoriteScreen
import com.kelvin.catalogue.presentation.theme.AppTheme

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Popular", "Favorite")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                )
            }
        }
        when (tabIndex) {
            0 -> DashboardScreen(navController = navController)
            1 -> FavoriteScreen(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}
