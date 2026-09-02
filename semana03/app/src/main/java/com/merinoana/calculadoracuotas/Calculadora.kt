package com.merinoana.calculadoracuotas

fun main() {
    println("=== CALCULADORA DE CUOTAS ===")

    print("Ingrese el nombre del producto: ")
    val nombreProducto = readln()

    print("Ingrese el precio del producto: ")
    val precio = readln().toDouble()

    print("Ingrese la cantidad: ")
    val cantidad = readln().toInt()

    var cuotas = 0
    while (cuotas != 6 && cuotas != 12 && cuotas != 24) {
        print("Ingrese el número de cuotas (Solo se permite 6, 12 o 24): ")
        cuotas = readln().toInt()

        if (cuotas != 6 && cuotas != 12 && cuotas != 24) {
            println("-> Error: Valor inválido. Debe elegir 6, 12 o 24 cuotas.\n")
        }
    }

}