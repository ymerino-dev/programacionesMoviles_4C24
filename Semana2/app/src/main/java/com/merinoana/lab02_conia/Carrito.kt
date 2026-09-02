package com.merinoana.lab02_conia

// Modelo de datos solicitado
data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)

// --- INICIO PARTE 3: Funciones de calculo ---
fun calcularSubtotal(productos: List<Producto>): Double {
    var subtotal = 0.0
    for (p in productos) {
        subtotal += p.precio * p.cantidad
    }
    return subtotal
}

fun calcularIGV(subtotal: Double): Double {
    return subtotal * 0.18 // 18% del subtotal
}

fun calcularTotal(subtotal: Double, igv: Double): Double {
    return subtotal + igv
}

fun main() {
    println("=========================================")
    println("   CARRITO DE COMPRAS - TIENDA TECSUP    ")
    println("=========================================")

    print("Ingrese el nombre del cliente: ")
    val nombreCliente = readln()
    println("Cliente: $nombreCliente\n")
}