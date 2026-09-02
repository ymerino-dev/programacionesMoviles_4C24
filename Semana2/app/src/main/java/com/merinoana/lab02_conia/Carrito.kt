package com.merinoana.lab02_conia

data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int
)

fun calcularSubtotal(productos: List<Producto>): Double {
    var subtotal = 0.0
    for (p in productos) {
        subtotal += p.precio * p.cantidad
    }
    return subtotal
}

fun calcularIGV(subtotal: Double): Double {
    return subtotal * 0.18
}

fun calcularTotal(subtotal: Double, igv: Double): Double {
    return subtotal + igv
}

// --- INICIO PARTE 4: Reporte con formato ---
fun mostrarDetalle(productos: List<Producto>) {
    println("--------- DETALLE DEL CARRITO --------")
    var i = 1
    for (p in productos) {
        val importe = p.precio * p.cantidad
        // %-20s alinea a la izquierda (20 espacios), %8.2f alinea a la derecha (8 espacios, 2 decimales)
        println(String.format("%d. %-20s x%d S/ %8.2f", i, p.nombre, p.cantidad, importe))
        i++
    }
    println("--------------------------------------")
}
// --- FIN PARTE 4 ---

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

    // Llamando a la funcion de formato
    mostrarDetalle(carrito)

    val subtotal = calcularSubtotal(carrito)
    val igv = calcularIGV(subtotal)
    val totalPagar = calcularTotal(subtotal, igv)

    // Totales alineados con 2 decimales
    println(String.format("Cantidad de productos : %d", carrito.size))
    println(String.format("Subtotal              : S/ %.2f", subtotal))
    println(String.format("IGV (18%%)             : S/ %.2f", igv))
    println(String.format("TOTAL A PAGAR         : S/ %.2f", totalPagar))
}