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

}
