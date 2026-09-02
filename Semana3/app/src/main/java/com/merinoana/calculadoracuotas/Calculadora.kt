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
    // Cálculos matemáticos
    val montoInicial = precio * cantidad

    // Determinar el porcentaje según las cuotas (20%, 40% o 60%)
    val porcentajeInteres = when (cuotas) {
        6 -> 0.20
        12 -> 0.40
        24 -> 0.60
        else -> 0.0
    }

    val montoInteres = montoInicial * porcentajeInteres
    val montoTotalAPagar = montoInicial + montoInteres
    val pagoMensual = montoTotalAPagar / cuotas

    // Mostrar Resultados
    println("\n==================================")
    println("      RESUMEN DE LA COMPRA")
    println("==================================")
    println("Producto: $nombreProducto")
    println("Monto inicial: S/ $montoInicial")
    println("Interés aplicado: ${(porcentajeInteres * 100).toInt()}%")
    println("Monto a pagar con interés: S/ $montoTotalAPagar")
    println("Pago mensual: S/ $pagoMensual")

    // Calendario de pagos
    println("\n--- CALENDARIO DE PAGOS ($cuotas MESES) ---")
    for (mes in 1..cuotas) {
        println("Mes $mes: S/ $pagoMensual")
    }
    println("==================================")

}