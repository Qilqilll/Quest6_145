package com.example.praktikum8

import DataJK.jenisK
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum8.view.FormSiswa
import com.example.praktikum8.view.TampilSiswa
import com.example.praktikum8.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulirku,
    Detail
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel ()
){
    Scaffold { isiRuang->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                val konteks = LocalContext.current
                FormSiswa (
                    pilihanJK = jenisK.map { id -> konteks.resources.getString(id)},
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilSiswa (
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = {
                        cancelAndBackToFormulirku(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirku(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Formulirku.name,
        inclusive = false)
}