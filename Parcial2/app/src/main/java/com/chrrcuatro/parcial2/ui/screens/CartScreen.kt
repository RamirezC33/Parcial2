package com.chrrcuatro.parcial2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chrrcuatro.parcial2.viewmodel.ProductViewModel
import com.chrrcuatro.parcial2.ui.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(viewModel: ProductViewModel) {
    val cart by viewModel.cart.collectAsState()

    Scaffold(topBar = { TopAppBar(title = { Text("Carrito") }) }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            if (cart.isEmpty()) {
                Text("El carrito está vacío.")
            } else {
                LazyColumn {
                    items(cart) { product ->
                        ProductCard(product)
                    }
                }
            }
        }
    }
}
