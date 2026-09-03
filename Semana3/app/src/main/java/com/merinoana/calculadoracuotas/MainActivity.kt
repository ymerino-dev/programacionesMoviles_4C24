    package com.merinoana.calculadoracuotas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.merinoana.calculadoracuotas.ui.theme.CalculadoraCuotasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraCuotasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        PantallaRegistro( Modifier.padding(innerPadding))
                    )
                }
            }
        }
    }

    @Composable
    fun PantallaRegistro(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Nuevo producto",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Completa los datos y presiona Agregar",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre del producto") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = precio,
                    onValueChange = { precio = it },
                    label = { Text("Precio (S/)") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                OutlinedTextField(
                    value = cantidad,
                    onValueChange = { cantidad = it },
                    label = { Text("Cantidad") },
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { mostrarResumen = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("AGREGAR PRODUCTO")
                }

                Spacer(modifier = Modifier.height(24.dp))

                if (mostrarResumen) {
                    val precioNum = precio.toDoubleOrNull() ?: 0.0
                    val cantidadNum = cantidad.toIntOrNull() ?: 0
                    val importe = precioNum * cantidadNum

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(nombre, style = MaterialTheme.typography.titleLarge)
                            Text("Precio: S/" + String.format("%.2f", precioNum))
                            Text("Cantidad: $cantidadNum")
                            Text(
                                "Importe total: S/" + String.format("%.2f", importe),
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "✓ Producto registrado correctamente",
                        color = Color(0xFF2E7D32)

                }

        }
    }
}


