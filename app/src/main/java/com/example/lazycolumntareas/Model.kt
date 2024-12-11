package com.example.lazycolumntareas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Model(
    var tarea: String,
){
    var estado: Boolean by mutableStateOf(false)
}