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

    val carrito = mutableListOf<Producto>()

    var agregarMas = true
    while (agregarMas) {
        print("Ingrese producto: ")
        val nombreProd = readln()
        print("Ingrese precio: ")
        val precioProd = readln().toDouble()
        print("Ingrese cantidad: ")
        val cantidadProd = readln().toInt()

        carrito.add(Producto(nombreProd, precioProd, cantidadProd))
        println("-> Producto agregado: $nombreProd\n")

        print("¿Desea agregar otro producto? (s/n): ")
        if (readln().lowercase() != "s") agregarMas = false
        println()
    }

    // Llamando a las funciones para mostrar resultados (Parte 3)
    val subtotal = calcularSubtotal(carrito)
    val igv = calcularIGV(subtotal)
    val totalPagar = calcularTotal(subtotal, igv)

    println("Subtotal : S/ $subtotal")
    println("IGV (18%): S/ $igv")
    println("TOTAL    : S/ $totalPagar")
}