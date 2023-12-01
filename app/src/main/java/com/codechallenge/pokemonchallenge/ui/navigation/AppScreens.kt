package com.codechallenge.pokemonchallenge.ui.navigation

sealed class AppScreens(val route :String){
    object PokemonList :AppScreens("pokemon_list")
    object PokemonDetails :AppScreens("pokemon_details")
}
