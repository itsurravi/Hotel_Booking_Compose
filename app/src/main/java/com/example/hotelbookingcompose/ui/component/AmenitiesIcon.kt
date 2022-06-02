package com.example.hotelbookingcompose.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hotelbookingcompose.ui.theme.MainColor

@Composable
fun AmenitiesIcon(
    iconId: Int,
    description: String,
    start: Dp,
    end: Dp,
    top: Dp,
    bottom: Dp
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .padding(start = start, end = end, top = top, bottom = bottom)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .size(60.dp)
                .clip(CircleShape)
                .border(1.dp, Color.LightGray, CircleShape)
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = description,
                tint = MainColor
            )
        }
        Text(
            text = description, color = MainColor
        )
    }
}