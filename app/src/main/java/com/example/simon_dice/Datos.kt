package com.example.simon_dice

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData

/**
 * Clase Datos que se encarga de almacenar los datos de la aplicación.
 */
object Datos {
    // Se inicializa la variable numero en 0
    var numero: Int = 0
    var ronda : MutableLiveData <Int> = MutableLiveData(0)
}

/**
 * Enumeración de los colores de los botones.
 */
enum class ColorButton(val color: Color, val label: String, val value: Int) {
    VERDE(Color.Green, "Verde", 1),
    ROJO(Color.Red, "Rojo", 2),
    AMARILLO(Color.Yellow, "Amarillo", 3),
    AZUL(Color.Blue, "Azul", 4)
}
