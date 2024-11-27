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
