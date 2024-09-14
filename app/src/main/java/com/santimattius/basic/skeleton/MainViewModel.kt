package com.santimattius.basic.skeleton

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santimattius.basic.skeleton.core.data.CharactersRepository
import com.santimattius.basic.skeleton.core.domain.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@Stable
data class MainUiState(
    val isLoading: Boolean = false,
    val withError: Boolean = false,
    val errorMessage: String = "",
    val characters: List<Character> = emptyList(),
)

@KoinViewModel
class MainViewModel(
    private val repository: CharactersRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState>
        get() = _state.asStateFlow()

    fun load() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            repository.getCharacters().onSuccess { characters ->
                _state.update { it.copy(isLoading = false, characters = characters) }
            }.onFailure {
                _state.update { it.copy(isLoading = false, withError = true) }
            }
        }
    }
}