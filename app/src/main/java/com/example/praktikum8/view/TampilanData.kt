package com.example.praktikum8.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.praktikum8.R
import com.example.praktikum8.model.Siswa

@Composable
fun TampilSiswa(
    // edit 1 : parameter statusUiSiswa
    statusUiSiswa: Siswa,
    onBackButtonClicked:() -> Unit
){

    // edit 2 : items Pair
    val items = listOf(
        Pair(first = stringResource(id = R.string.nama),   second = statusUiSiswa.nama),
        Pair(first = stringResource(id = R.string.gender), second = statusUiSiswa.gender),
        Pair(first = stringResource(id = R.string.alamat), second = statusUiSiswa.alamat)
    )