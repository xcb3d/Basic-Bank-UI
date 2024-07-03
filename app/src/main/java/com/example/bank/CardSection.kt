package com.example.bank

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank.data.CardData
import com.example.bank.ui.theme.BlueEnd
import com.example.bank.ui.theme.BlueStart
import com.example.bank.ui.theme.GreenEnd
import com.example.bank.ui.theme.GreenStart
import com.example.bank.ui.theme.OrangeEnd
import com.example.bank.ui.theme.OrangeStart
import com.example.bank.ui.theme.PurpleEnd
import com.example.bank.ui.theme.PurpleStart

val cards = listOf(
    CardData(
        cardType = "Visa",
        cardNumber = "1234 5678 9012 3456",
        cardName = "John Doe",
        cardBalance = 1234.56,
        cardBackgroundColor = getGradient(PurpleStart, PurpleEnd)
    ),
    CardData(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "John Doe",
        cardBalance = 1234.56,
        cardBackgroundColor = getGradient(BlueStart, BlueEnd)
    ),
    CardData(
        cardType = "Visa",
        cardNumber = "1234 5678 9012 3456",
        cardName = "John Doe",
        cardBalance = 1234.56,
        cardBackgroundColor = getGradient(OrangeStart, OrangeEnd)
    ),
    CardData(
        cardType = "MASTER CARD",
        cardNumber = "1234 5678 9012 3456",
        cardName = "John Doe",
        cardBalance = 1234.56,
        cardBackgroundColor = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(
    startColor: Color,
    endColor: Color
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            startColor,
            endColor
        )
    )
}

@Composable
fun CardItem(
    index: Int,
) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size - 1) {
        lastItemPaddingEnd = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .width(250.dp)
                .height(160.dp)
                .background(card.cardBackgroundColor)
                .padding(
                    vertical = 12.dp,
                    horizontal = 16.dp,
                )
                .clickable {  },
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier.width(60.dp)
            )
            Text(text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "$ ${card.cardBalance}",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold)
            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun CardSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}