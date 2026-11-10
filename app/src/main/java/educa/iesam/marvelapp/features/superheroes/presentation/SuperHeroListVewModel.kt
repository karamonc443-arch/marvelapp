package educa.iesam.marvelapp.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import educa.iesam.marvelapp.features.superheroes.domain.SuperHero

class SuperHeroListVewModel(): ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState
    fun loadSuperHeroes(){
        _uiState.value = UiState(isLoading = true)
        _uiState.postValue(UiState(isLoading = true))
        _uiState.value = UiState(superHeroes = emptyList())
    }
    data class UiState(val isLoading: Boolean = false,
                       val hasError: Boolean = false,
                       val superHeroes: List<SuperHero>? = null)
}