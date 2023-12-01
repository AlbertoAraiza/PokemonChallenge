package com.codechallenge.pokemonchallenge.domain

import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepository
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepositoryImpl
import javax.inject.Inject

class LoadPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
){
    suspend operator fun invoke(offset :Int?) :List<Pokemon>{
//        val data = pokemons?.map { Pokemon(it.name) }
        return repository.getPokemons(offset)?: emptyList()
    }
}