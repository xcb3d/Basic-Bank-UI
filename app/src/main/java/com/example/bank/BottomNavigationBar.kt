package com.example.bank

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bank.data.BottomNavigationData

val items = listOf(
    BottomNavigationData(
        title = "Home",
        icon = Icons.Rounded.Home
    ),
    BottomNavigationData(
        title = "Wallet",
        icon = Icons.Rounded.Wallet
    ),
    BottomNavigationData(
        title = "Notification",
        icon = Icons.Rounded.Notifications
    ),
    BottomNavigationData(
        title = "Account",
        icon = Icons.Rounded.AccountCircle
    ),


    )

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        Row (
            modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
        ){
            items.forEachIndexed {
                index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = { /*TODO*/ },
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(item.title) }
                )
            }
        }
    }
}