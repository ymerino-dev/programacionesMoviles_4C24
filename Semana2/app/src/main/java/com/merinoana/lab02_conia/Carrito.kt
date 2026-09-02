package com.merinoana.lab02_conia

// Modelo de datos solicitado
data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)

fun main() {
    println("=========================================")
    println("   CARRITO DE COMPRAS - TIENDA TECSUP    ")
    println("=========================================")

    print("Ingrese el nombre del cliente: ")
    val nombreCliente = readln()
    println("Cliente: $nombreCliente\n")
}