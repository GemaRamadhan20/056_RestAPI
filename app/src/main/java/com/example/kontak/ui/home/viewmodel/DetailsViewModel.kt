package com.example.kontak.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kontak.model.Kontak
import com.example.kontak.repository.KontakRepository
import com.example.kontak.ui.home.screen.DetailsDestination
import kotlinx.coroutines.launch

sealed class DetailsKontakUiState {
    data class Success(
        val kontak: Kontak
    ) : DetailsKontakUiState()

    object Error : DetailsKontakUiState()
    object Loading : DetailsKontakUiState()
}

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val kontakRepository: KontakRepository
) : ViewModel() {


    private val kontakId: Int = checkNotNull(savedStateHandle[DetailsDestination.kontakId])
    var detailsKontakUiState: DetailsKontakUiState by mutableStateOf(DetailsKontakUiState.Loading)
        private set

    init {
        getKontakById()

    }
    fun getKontakById() {
        viewModelScope.launch {
            detailsKontakUiState = DetailsKontakUiState.Loading
            detailsKontakUiState = try {
                DetailsKontakUiState.Success(
                    kontak = kontakRepository.getKontakById(kontakId)
                )
            } catch (e: Exception) {
                DetailsKontakUiState.Error
            }
        }

    }
}