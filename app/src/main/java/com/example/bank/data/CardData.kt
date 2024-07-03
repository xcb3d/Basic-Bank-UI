package com.example.bank.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

data class CardData(
    val cardType : String,
    val cardNumber : String,
    val cardName : String,
    val cardBalance : Double,
    val cardBackgroundColor : Brush
)
