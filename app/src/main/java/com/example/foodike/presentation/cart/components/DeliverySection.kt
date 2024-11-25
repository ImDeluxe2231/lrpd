package com.example.foodike.presentation.cart.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.foodike.domain.model.Restaurant
import com.example.foodike.presentation.common.getTimeInMins

@Composable
fun DeliverySection(
    restaurant: Restaurant
) {
    Column(modifier = Modifier.padding(16.dp)) {


        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = 16.dp

        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Entregar a:", fontWeight = FontWeight.Bold)
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Atrás",
                            modifier = Modifier.alpha(0.5f),
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(text = "Ubicación:")
                        Text(text = "Tiempo estimado:")
                    }
                    Column {
                        Text(text = "Grocio Prado")
                        Text(text = restaurant.timeInMillis.getTimeInMins())
                    }


                }

            }
        }
    }
}

