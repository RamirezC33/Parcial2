package com.chrrcuatro.parcial2.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.chrrcuatro.parcial2.data.Product
import com.chrrcuatro.parcial2.data.products

class ProductViewModel : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _productList = MutableStateFlow(products)
    val filteredProducts: StateFlow<List<Product>> = _productList

    private val _cart = MutableStateFlow<List<Product>>(emptyList())
    val cart: StateFlow<List<Product>> = _cart

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        _productList.value = products.filter {
            it.name.contains(query, ignoreCase = true) || it.category.contains(query, ignoreCase = true)
        }
    }

    fun getProductById(id: Int): Product? = products.find { it.id == id }

    fun addToCart(product: Product) {
        if (!_cart.value.contains(product)) {
            product.addedToCart = true
            _cart.value = _cart.value + product
        }
    }
}