package com.chrrcuatro.parcial2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.chrrcuatro.parcial2.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductViewModel) {
    val product = viewModel.getProductById(productId)
    val context = LocalContext.current

    if (product == null) {
        Text("Producto no encontrado")
        return
    }

    Scaffold(topBar = { TopAppBar(title = { Text(product.name) }) }) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(product.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Categoría: ${product.category}")
            Text("Precio: \$${product.price}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(product.description)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                viewModel.addToCart(product)
                Toast.makeText(context, "Producto agregado al carrito", Toast.LENGTH_SHORT).show()
            }) {
                Text("Agregar al carrito")
            }
        }
    }
}
