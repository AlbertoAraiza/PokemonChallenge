package com.codechallenge.pokemonchallenge.ui.screens.pokemon_list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.codechallenge.pokemonchallenge.core.Event
import com.codechallenge.pokemonchallenge.core.Resource
import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.codechallenge.pokemonchallenge.domain.LoadPokemonsUseCase
import com.codechallenge.pokemonchallenge.ui.navigation.AppScreens
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val loadPokemons :LoadPokemonsUseCase
) :ViewModel() {
    //state
    var pokemons by mutableStateOf<List<Pokemon>>(emptyList())
    //private val _pokemons = MutableLiveData<Event<Resource<Pokemon>>>()
    //val pokemons :LiveData<Event<Resource<Pokemon>>> = _pokemons

    //Atributes

    //methods
    fun loadMore() {
        viewModelScope.launch {
            val offset = if (pokemons.isEmpty()) null else pokemons.size + 1
            loadPokemons(offset).let {
                pokemons = pokemons.plus(it)
            }
            Log.d("JSON", Gson().toJson(pokemons))
        }
    }

    fun detailsPokemon(pokemon: Pokemon): String {
        val pokeNumber = pokemon.url.split('/')[6]
        return AppScreens.PokemonDetails.route + "?pokeName=${pokemon.name}&pokeNumber=$pokeNumber"
        //navController.navigate()
    }

}