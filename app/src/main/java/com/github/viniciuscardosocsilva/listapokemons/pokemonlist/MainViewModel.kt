package com.github.viniciuscardosocsilva.listapokemons.ui.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.github.viniciuscardosocsilva.listapokemons.data.PokemonRepository

class MainViewModel(repository: PokemonRepository) : ViewModel() {
    val pokemonList = repository.getPokemonList().cachedIn(viewModelScope)
}