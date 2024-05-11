package com.example.borrowbee.ui.components.navigation

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
                        fontSize = 12.sp,
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
                    .weight(1f),

            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("HomeTab")
}





