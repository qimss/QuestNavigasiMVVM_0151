package com.example.firstapp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.view.FormIsian
import com.example.firstapp.view.TampilData
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

enum class Navigasi{
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
){
    Scaffold() {
        isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.FormulirSaya.name){
                FormIsian (
                    OnSubmitBtnClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilData (
                    onBackBtnClick = {cancelAndBackToFormulirSaya(navController)
                    }
                )
            }
        }
    }
}

fun cancelAndBackToFormulirSaya(
    navController: NavHostController
){
    navController.popBackStack(Navigasi.FormulirSaya.name, inclusive = false)
}