package com.example.borrowbee.ui.components.BottomNavigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.borrowbee.ui.screens.BottomNavigationScreens

@Composable
fun BottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    NavigationBar (
        modifier = Modifier
            .height(80.dp) /// 80 is the recommended for material 3
            .fillMaxWidth()
            .padding(top = 12.dp)

    ){
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        screen.icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp))
                       },
                label = {
                    Text(
                        stringResource(id = screen.resourceId),
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 4.dp)
                        )
                        },
                selected = currentRoute == screen.route,
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                },
                modifier = Modifier
                    //.padding(horizontal = 12.dp)
                    .weight(1f),

                //modifier = Modifier.background(color = MaterialTheme.colorScheme.surface), // Use MaterialTheme colors
                //selectedIconContentColor = MaterialTheme.colorScheme.primary, // Use MaterialTheme colors
                //
                // unselectedContentColor = colorResource(id = R.color.icon_color) // You can keep custom color here
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("HomeTab")
}





