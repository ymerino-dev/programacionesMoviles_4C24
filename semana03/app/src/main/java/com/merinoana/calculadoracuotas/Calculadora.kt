package com.merinoana.calculadoracuotas

fun main() {
    println("=== CALCULADORA DE CUOTAS ===")

    print("Ingrese el nombre del producto: ")
    val nombreProducto = readln()

    print("Ingrese el precio del producto: ")
    val precio = readln().toDouble()

    print("Ingrese la cantidad: ")
    val cantidad = readln().toInt()
}