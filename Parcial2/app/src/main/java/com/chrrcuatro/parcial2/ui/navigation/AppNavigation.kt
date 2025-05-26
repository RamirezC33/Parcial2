package com.chrrcuatro.parcial2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.chrrcuatro.parcial2.ui.screens.*
import com.chrrcuatro.parcial2.viewmodel.ProductViewModel

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
    object Cart : Screen("cart")
}

@Composable
fun AppNavigation(viewModel: ProductViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            ProductListScreen(navController, viewModel)
        }
        composable(
            Screen.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("id") ?: return@composable
            ProductDetailScreen(productId = id, viewModel = viewModel)
        }
        composable(Screen.Cart.route) {
            CartScreen(viewModel)
        }
    }
}
