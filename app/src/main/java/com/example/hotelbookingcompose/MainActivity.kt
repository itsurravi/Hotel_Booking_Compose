package com.example.hotelbookingcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.hotelbookingcompose.ui.HotelScreen
import com.example.hotelbookingcompose.ui.theme.HotelBookingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelBookingComposeTheme {
                HotelScreen() { itemCLick ->
                    when(itemCLick) {
                        ItemCLick.BACK -> {
                            Toast.makeText(this, "Back Pressed", Toast.LENGTH_SHORT).show()
                        }
                        ItemCLick.SHARE -> {
                            Toast.makeText(this, "Share Pressed", Toast.LENGTH_SHORT).show()
                        }
                        ItemCLick.FAV -> {
                            Toast.makeText(this, "Fav Pressed", Toast.LENGTH_SHORT).show()
                        }
                        ItemCLick.VIEW_MORE -> {
                            Toast.makeText(this, "View Pressed", Toast.LENGTH_SHORT).show()
                        }
                        ItemCLick.SEE_ALL -> {
                            Toast.makeText(this, "See All Pressed", Toast.LENGTH_SHORT).show()
                        }
                        ItemCLick.BOOK_BUTTON -> {
                            Toast.makeText(this, "Book Now Pressed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}