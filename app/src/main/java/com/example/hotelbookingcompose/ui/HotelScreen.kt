package com.example.hotelbookingcompose.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hotelbookingcompose.Amenities
import com.example.hotelbookingcompose.ItemCLick
import com.example.hotelbookingcompose.R
import com.example.hotelbookingcompose.ui.component.AmenitiesIcon
import com.example.hotelbookingcompose.ui.component.CircularIcon
import com.example.hotelbookingcompose.ui.component.HostProfileIcon
import com.example.hotelbookingcompose.ui.component.RoundBoxChip
import com.example.hotelbookingcompose.ui.theme.*

//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
@Composable
fun HotelScreen(
    itemClick: (ItemCLick) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MainBackground
            )
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            item {
                TopIconSection(itemClick = itemClick)
                HostInfoSection(
                    "Hosted by Andik",
                    "Supreme Host",
                    R.drawable.ic_person
                )
                HotelLocationSection(
                    "House of Mormon, no. XII Frostmourne",
                    "Bantul, Yogyakarta",
                    listOf(
                        "4.8",
                        "800 Reviews",
                        "3 Guests",
                    )
                )
                Divider()
                HotelDescriptionSection(itemClick = itemClick)
                HotelAmenitiesSection(itemClick = itemClick)
            }
        }
        BottomPriceSection(modifier = Modifier, itemClick = itemClick)
    }
}

@Composable
fun TopIconSection(itemClick: (ItemCLick) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        CircularIcon(
            iconId = R.drawable.ic_back,
            description = "Back",
            iconTintColor = MainColor,
            modifier = Modifier,
            itemClick = itemClick
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularIcon(
                R.drawable.ic_share,
                "Share",
                iconTintColor = MainColor,
                modifier = Modifier
                    .padding(end = 10.dp),
                itemClick = itemClick
            )
            CircularIcon(
                R.drawable.ic_fav,
                "Favorite",
                iconTintColor = FavRed,
                modifier = Modifier,
                itemClick = itemClick
            )
        }
    }
}

@Composable
fun HostInfoSection(
    hostTitle: String,
    hostSubtitle: String,
    iconId: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        HostProfileIcon(iconId)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp)
        ) {
            Text(
                text = hostTitle,
                style = MaterialTheme.typography.body1,
                color = MainColor
            )
            Text(
                text = hostSubtitle,
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun HotelLocationSection(
    hotelName: String,
    hotelLocation: String,
    reviewList: List<String>
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
    ) {
        Text(
            text = hotelName,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Medium,
            color = MainColor,
            fontSize = 18.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(top = 10.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "Location",
                tint = MainColor
            )
            Text(
                text = hotelLocation,
                color = Color.Gray
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            items(reviewList.size) {
                RoundBoxChip(title = reviewList[it])
            }
        }
    }
}

@Composable
fun Divider() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .background(DividerColor)
            .size(10.dp)
    )
}

@Composable
fun HotelDescriptionSection(
    itemClick: (ItemCLick) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.pool),
                contentDescription = "Pool Image",
            )
        }

        val annotatedString = buildAnnotatedString {
            append(stringResource(id = R.string.hotelDescription))
            pushStringAnnotation("VIEW_MORE", "VIEW_MORE")
            withStyle(
                style = SpanStyle(fontWeight = FontWeight.Medium, color = MainColor)
            ) {
                append("View More")
            }
            pop()
        }
        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "VIEW_MORE", offset, offset)
                    .firstOrNull()?.let {
                        itemClick(ItemCLick.VIEW_MORE)
                    }
            },
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun HotelAmenitiesSection(
    itemClick: (ItemCLick) -> Unit
) {
    val amenities = listOf(
        Amenities(R.drawable.ic_wifi, "Wifi"),
        Amenities(R.drawable.ic_pool, "Pools"),
        Amenities(R.drawable.ic_dinner, "Dinner"),
        Amenities(R.drawable.ic_ac, "AC"),
        Amenities(R.drawable.ic_wifi, "Wifi"),
        Amenities(R.drawable.ic_pool, "Pools"),
        Amenities(R.drawable.ic_dinner, "Dinner"),
        Amenities(R.drawable.ic_ac, "AC")
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Amenities",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = MainColor
            )
            Text(
                text = "See All",
                color = Color.Gray,
                modifier = Modifier.clickable {
                    itemClick(ItemCLick.SEE_ALL)
                }
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(amenities.size) {
                AmenitiesIcon(
                    iconId = amenities[it].iconId,
                    description = amenities[it].title,
                    if (it == 0) 0.dp else 10.dp,
                    if (it == amenities.size - 1) 0.dp else 10.dp,
                    10.dp,
                    10.dp
                )
            }
        }
    }
}

@Composable
fun BottomPriceSection(
    modifier: Modifier,
    itemClick: (ItemCLick) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(BillBarColor)
            .padding(
                horizontal = 14.dp,
                vertical = 6.dp
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = "$420",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    color = MainColor
                )
                Text(
                    text = "25 - 28 Feb",
                    modifier = Modifier.padding(top = 4.dp),
                    color = MainColor
                )
            }

            Button(
                onClick = {
                    itemClick(ItemCLick.BOOK_BUTTON)
                },
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Green
                )
            ) {
                Text(text = "Book Now", color = Color.White)
            }
        }
    }
}