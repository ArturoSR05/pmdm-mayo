package edu.iesam.pmdm_mayo.features.client.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.pmdm_mayo.features.client.domain.Client
import edu.iesam.pmdm_mayo.features.client.domain.GetClientsUseCase
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClientViewModel(private val getClientsUseCase: GetClientsUseCase): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadClients() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch {
            val clients = getClientsUseCase.invoke()
            _uiState.value = UiState(clients = clients, true, null)
        }
    }

    data class UiState(
        val clients: List<Client>? = null,
        val isLoading: Boolean? = null,
        val errorApp: String? = null
    )
}