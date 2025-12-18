package com.example.localrestapi.view.uicontroller

import com.example.localrestapi.view.EntrySiswaScreen
import com.example.localrestapi.view.HomeScreen
import com.example.localrestapi.view.route.DestinasiEntry
import com.example.localrestapi.view.route.DestinasiHome
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier){
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier ){
        composable(DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
//                    navController.navigate("${DestinasiDetail.route}/${it}")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.navigate(DestinasiHome
                .route) })
        }
    }
}