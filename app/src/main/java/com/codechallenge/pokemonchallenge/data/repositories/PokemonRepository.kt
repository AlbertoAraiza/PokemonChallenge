package com.codechallenge.pokemonchallenge.data.repositories

import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse

interface PokemonRepository {
    suspend fun getPokemons(offset :Int?) :List<Pokemon>?
    suspend fun getDetails(number :Int) : DetailsResponse?
}