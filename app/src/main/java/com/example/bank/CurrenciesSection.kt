package com.example.bank

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank.data.CurrenciesData
import com.example.bank.ui.theme.GreenStart

val currencies = listOf(
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),
    CurrenciesData(
        icon = Icons.Rounded.AttachMoney,
        currency = "USD",
        buy = "34.56",
        sell = "34.56"
    ),


    )

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(true)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowDown)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize { initialValue, targetValue -> },
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize { initialValue, targetValue -> }
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        if (isVisible) {
                            iconState = Icons.Rounded.KeyboardArrowDown
                        } else {
                            iconState = Icons.Rounded.KeyboardArrowUp
                        }
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp)
                )

            }
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraintsScope = this
                    val width = boxWithConstraintsScope.maxWidth / 3
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 16.dp, bottom = 16.dp, start = 16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Currency",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Buy",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp,
                                textAlign = TextAlign.End
                            )
                            Text(
                                text = "Sell",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 16.sp,
                                textAlign = TextAlign.End
                            )

                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        LazyColumn {
                            items(currencies.size) { index ->
                                CurrenciesItem(index, width)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrenciesItem(index: Int, width: Dp) {
    val currencies = currencies[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(GreenStart)
                    .padding(4.dp)

            ) {
                Icon(
                    imageVector = currencies.icon,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            }
            Text(
                text = currencies.currency,
                modifier = Modifier
                    .width(width)
                    .padding(start = 10.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 16.sp,
            )
        }
        Text(
            text = "$ " + currencies.buy,
            modifier = Modifier
                    .width(width)
                .padding(start = 10.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )

        Text(
            text = "$ " + currencies.sell,
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 16.sp,
            textAlign = TextAlign.End
        )
    }

}
