package com.example.simon_dice

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class ModelView() : ViewModel() {

    private val TAG_LOG = "miDebug"

    //Almacena el estado del juego como observable.
    val estadoLiveData: MutableLiveData<Estados> = MutableLiveData(Estados.INICIO)

    var buttons = mutableStateOf(listOf<ButtonData>())

    //Almacena el mensaje que se muestra en la pantalla
    var mensajeC = mutableStateOf("")

    //Lista de colores
    private val secuenciaColores = mutableListOf<ColorButton>()

    //Almacena el índice actual de la secuencia de colores
    private var indiceActual = 0

    /**
     * Inicio la clase ModelView.
     * Inicio estado y botones.
     */
    init {
        Log.d(TAG_LOG,"Estado: ${estadoLiveData.value}")
        buttons.value = getButtons()
    }

    /**
     * Muestra la secuencia de colores.
     * Cambia el estado a ADIVINANDO.
     */
    private fun mostrarSecuencia() {
        viewModelScope.launch {
            for (color in secuenciaColores) {
                mensajeC.value = color.label
                delay(500)
                mensajeC.value = ""
                delay(500)
            }
            delay(500)
            estadoLiveData.value = Estados.ADIVINANDO
            indiceActual = 0
        }
    }

    /**
     * Listar botones
     */
    fun getButtons(): List<ButtonData> {
        return listOf(
            ButtonData(ColorButton.VERDE, RoundedCornerShape(bottomEnd = 180.dp)),
            ButtonData(ColorButton.ROJO, RoundedCornerShape(bottomStart = 180.dp)),
            ButtonData(ColorButton.AMARILLO, RoundedCornerShape(topEnd = 180.dp)),
            ButtonData(ColorButton.AZUL, RoundedCornerShape(topStart = 180.dp))
        )
    }
}
