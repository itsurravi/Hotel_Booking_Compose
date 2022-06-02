package com.example.hotelbookingcompose.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.hotelbookingcompose.ui.theme.RoundChipBorderColor

@Composable
fun RoundBoxChip(title: String) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(
                width = 1.dp,
                color = RoundChipBorderColor
            )
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(
                    horizontal = 12.dp,
                    vertical = 4.dp
                ),
                fontWeight = FontWeight.Medium
            )
        }
    }
}