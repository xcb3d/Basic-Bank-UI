package com.example.bank.data

import androidx.compose.ui.graphics.vector.ImageVector

data class CurrenciesData(
    val icon : ImageVector,
    val currency : String,
    val buy : String,
    val sell : String

)