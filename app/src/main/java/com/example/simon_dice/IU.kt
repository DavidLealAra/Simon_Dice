package com.example.simon_dice

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

/**
 * Boton de inicio.
 */
@Composable
fun Boton_Start(viewModel: ModelView, estado: Estados) {
    Button(
        onClick = {
            viewModel.empezarJugar()
        },
        modifier = Modifier
            .padding(5.dp)
            .size(width = 150.dp, height = 30.dp),
        enabled = estado == Estados.INICIO || estado == Estados.PERDIDO
    ) {
        Text("Start")
    }
}
