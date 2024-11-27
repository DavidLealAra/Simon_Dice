package com.example.simon_dice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import com.example.simon_dice.ui.theme.Simon_DiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simon_DiceTheme {
                Surface(
                    color = Color.LightGray,
                    modifier = Modifier.fillMaxSize()
                ) {
                    IU(ModelView())
                }
            }
        }
    }
}