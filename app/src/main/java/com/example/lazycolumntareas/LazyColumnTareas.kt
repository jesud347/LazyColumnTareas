package com.example.lazycolumntareas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LazyColumnTareas(modifier: Modifier) {
    val context = LocalContext.current
    val listaTareas = remember { mutableStateListOf(*getListaTareas().toTypedArray()) }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listaTareas) { item ->
            ItemTarea(model = item) { }
        }
    }
}

@Composable
fun ItemTarea(model: Model, onItemSelected: (Model) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Black),
        modifier = Modifier
            .width(250.dp)
            .size(80.dp)
            .clickable { onItemSelected(model) }
    ) {
        Column {
            Text(
                text = model.tarea,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 15.sp
            )
            Row(modifier = Modifier) {
                Icon(
                    imageVector = if (model.estado) Icons.Default.CheckCircle else Icons.Default.Clear,
                    contentDescription = if (model.estado) "Completada" else "Pendiente",
                    tint = if (model.estado) Color.Green else Color.Gray
                )
                Button (onClick = { model.estado = !model.estado }) {
                    Text(text = if (model.estado) "Marcar Pendiente" else "Marcar Completada")
                }
            }
        }
    }
}


fun getListaTareas(): List<Model>{
    return listOf(
        Model("Estudiar Acceso a Datos"),
        Model("Estudiar Kotlin"),
        Model("Entregar Proyecto Programacion"),
        Model("Estudiar Programacion Movil"),
        Model("Hacer la compra"),
        Model("Aprender a cocinar"),
        Model("Aprender programacion en macOS"),
        Model("Montar un ordenador"),
        Model("Reparar el telefono de mi tia"),
        Model("Comprar un libro"),
        Model("Comprar Regalo de navidad"),
        Model("Quedar para comer shushi"),
        Model("Diseñar una aplicacion de android"))
}