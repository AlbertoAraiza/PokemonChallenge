package com.codechallenge.pokemonchallenge.repositories

import android.accounts.NetworkErrorException
import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepository

class FakePokemonRepository :PokemonRepository {
    private var shouldReturnNetworError = false
    fun setShouldReturnNetworkError(value :Boolean){
        shouldReturnNetworError = value
    }

    override suspend fun getPokemons(offset: Int?): List<Pokemon>? {
        return if (shouldReturnNetworError){
             throw NetworkErrorException("No internet")
        }else{
            listOf(
                Pokemon("Bulbasaur", ""),
                Pokemon("Charmandar", ""),
                Pokemon("Squirtle", "")
            )
        }
    }

    override suspend fun getDetails(number: Int): DetailsResponse? {
        return if (shouldReturnNetworError){
            throw NetworkErrorException("No internet")
        }else{
            DetailsResponse(20,30)
        }
    }
}