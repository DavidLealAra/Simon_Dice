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
     * Función que finaliza el juego y cambia el estado a PERDIDO.
     */
    fun endGame() {
        estadoLiveData.value = Estados.PERDIDO
        mensajeC.value = "Perdiste"
        Datos.ronda.value = 0
        Log.d(TAG_LOG, "Estado: ${estadoLiveData.value}")
    }
    /**
     * Función que compara el color seleccionado con el color de la secuencia.
     */
    fun compararColorSeleccionado(colorSeleccionado: ColorButton): Boolean {
        if (colorSeleccionado == secuenciaColores[indiceActual]) {
            indiceActual++
            if (indiceActual == secuenciaColores.size) {
                estadoLiveData.value = Estados.GENERANDO
                viewModelScope.launch {
                    delay(1500)
                    agregarColorASecuencia()
                }
            }
            return true
        } else {
            endGame()
            return false
        }
    }
    /**
     * Agrega un color para que el usuario adivine.
     */
    fun agregarColorASecuencia() {
        val randomButtonIndex = (1..4).random()
        val nuevoColor = ColorButton.values().first { it.value == randomButtonIndex }
        secuenciaColores.add(nuevoColor)
        Datos.ronda.value = Datos.ronda.value?.plus(1) // Incrementa la ronda
        mostrarSecuencia()
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
