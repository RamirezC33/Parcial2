package com.chrrcuatro.parcial2.data

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Double,
    val description: String,
    val imageUrl: String,
    var addedToCart: Boolean = false
)

val products = listOf(
    Product(1, "Lenovo i5 pro", "Electrónica", 1450.99, "Laptop para trabajar y juegar.",
        "https://p4-ofp.static.pub/fes/cms/2023/02/14/chnlt92lwlgc2k9ep4gt0v6owg40ro570780.png"),
    Product(2, "Sony XM4", "Accesorios", 219.99, "Auriculares con Noise Cancelling.",
        "https://fulltec.com.bo/medios/2024/03/s-l1600-1.jpg"),
    Product(3, "Samsung Galaxy S21 Ultra", "Electrónica", 499.99, "Teléfono ultra para cosas ultras.",
        "https://images-cdn.ubuy.com.sa/638232c328e9d138ba2a89e3-samsung-galaxy-s21-ultra-g998u-5g.jpg"),
    Product(4, "Lenovo i5", "Electrónica", 1450.99, "Laptop para trabajar y juegar.",
        "https://p4-ofp.static.pub/fes/cms/2023/02/14/chnlt92lwlgc2k9ep4gt0v6owg40ro570780.png"),
    Product(5, "Sony XM4-2", "Accesorios", 219.99, "Auriculares con Noise Cancelling.",
        "https://fulltec.com.bo/medios/2024/03/s-l1600-1.jpg"),
    Product(6, "Samsung Galaxy S21 Ult", "Electrónica", 499.99, "Teléfono ultra para cosas ultras.",
        "https://images-cdn.ubuy.com.sa/638232c328e9d138ba2a89e3-samsung-galaxy-s21-ultra-g998u-5g.jpg"),
)
