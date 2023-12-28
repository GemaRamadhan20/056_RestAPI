package com.example.kontak.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kontak.KontakAplication
import com.example.kontak.ui.home.viewmodel.HomeViewModel
import com.example.kontak.ui.home.viewmodel.InsertViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiKontak().container.kontakRepository)
        }
        initializer {
            InsertViewModel(aplikasiKontak().container.kontakRepository)
        }
    }
}
fun CreationExtras.aplikasiKontak(): KontakAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as KontakAplication)