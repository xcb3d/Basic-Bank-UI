package com.example.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank.data.FinanceData
import com.example.bank.ui.theme.BlueStart
import com.example.bank.ui.theme.GreenStart
import com.example.bank.ui.theme.OrangeStart
import com.example.bank.ui.theme.PurpleStart

val finance = listOf(
    FinanceData(
        icon = Icons.Rounded.StarHalf,
        category = "My\nBusiness",
        background = OrangeStart
    ),
    FinanceData(
        icon = Icons.Rounded.StarHalf,
        category = "My\nBusiness",
        background = BlueStart
    ),
    FinanceData(
        icon = Icons.Rounded.StarHalf,
        category = "My\nBusiness",
        background = PurpleStart
    ),
    FinanceData(
        icon = Icons.Rounded.StarHalf,
        category = "My\nBusiness",
        background = GreenStart
    )
)

@Preview
@Composable
fun FinancesSection() {
    Column {
        Text(
            text = "Finances",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(finance.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val finance = finance[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(23.dp))
                .size(120.dp)
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .padding(16.dp)
                .clickable { },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .size(36.dp)
                    .background(finance.background)
            ) {
                Icon(
                    imageVector = finance.icon,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.padding(8.dp),
                    )

            }
            Text(
                text = finance.category,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
