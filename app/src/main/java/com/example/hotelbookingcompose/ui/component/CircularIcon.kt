package com.example.hotelbookingcompose.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hotelbookingcompose.ItemCLick

@Composable
fun CircularIcon(
    iconId: Int,
    description: String,
    iconTintColor: Color,
    modifier: Modifier,
    itemClick: (ItemCLick) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.dp, Color.LightGray, CircleShape)
            .clickable {
                when(description) {
                    "Back" -> itemClick(ItemCLick.BACK)
                    "Share" -> itemClick(ItemCLick.SHARE)
                    "Favorite" -> itemClick(ItemCLick.FAV)
                }
            }
            .padding(10.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = description,
            tint = iconTintColor
        )
    }
}