package com.example.localrestapi.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import com.example.localrestapi.R
import com.example.localrestapi.modeldata.DataSiswa
import com.example.localrestapi.viewmodel.DetailViewModel
import com.example.localrestapi.viewmodel.StatusUIDetail
import com.example.localrestapi.viewmodel.provider.PenyediaViewModel
import com.example.localrestapi.view.route.DestinasiDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailSiswaScreen(
    navigateToEditItem: (Int) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    // 🔥 RELOAD AMAN (tidak jalan saat delete)
    LaunchedEffect(viewModel.isDeleted) {
        if (!viewModel.isDeleted) {
            viewModel.getSatuSiswa()
        }
    }

