package com.example.foodike.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun GreetingSection(
    userName: String = "Josue"
) {
    val c: Calendar = Calendar.getInstance()
    val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
    Column(modifier = Modifier.padding(16.dp, 0.dp)) {
        Text(
            text = when (timeOfDay) {
                in 0..11 -> {
                    "Buenos Días!"
                }
                in 12..15 -> {
                    "Buenas Tardes!"
                }
                else -> {
                    "Buenas Noches!"
                }
            },
            fontSize = 28.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = userName,
            fontSize = 28.sp,
            fontWeight = FontWeight.Light
        )
    }
}
