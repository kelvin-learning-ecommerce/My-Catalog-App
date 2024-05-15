package com.kelvin.catalogue.presentation.favorite

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kelvin.catalogue.presentation.shared.NavigationItem
import com.kelvin.catalogue.presentation.favorite.viewmodel.FavoriteViewModel
import com.kelvin.catalogue.presentation.dashboard.PopularItemList

@Composable
fun FavoriteScreen(vm: FavoriteViewModel = hiltViewModel(), navController: NavHostController) {
    val state by vm.state.collectAsState()

    vm.getUsers()

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp),
    ) {
        items(state.data.size) { i ->
            PopularItemList(
                user = state.data[i],
                onItemClick = {
                    navController.navigate(NavigationItem.UserDetail.route)
                },
                isFavorite = true
            )
        }
    }
}
