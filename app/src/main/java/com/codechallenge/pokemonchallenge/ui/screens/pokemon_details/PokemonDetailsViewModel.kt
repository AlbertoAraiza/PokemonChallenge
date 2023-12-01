package com.codechallenge.pokemonchallenge.ui.screens.pokemon_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codechallenge.pokemonchallenge.domain.LoadDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val loadDetails: LoadDetailsUseCase
) :ViewModel(){
    //state
    var pokeNumber by mutableStateOf("")
    var pokeHeight by mutableStateOf("")
    var pokeWeight by mutableStateOf("")
    //methods
    fun loadData(number :Int){
        pokeNumber = "#$number"
        viewModelScope.launch {
            val data = loadDetails(number)
            pokeHeight = (data.height * 10).toString() + " cm."
            pokeWeight = (data.weight / 10f).toString() + " kg."
        }
    }
}