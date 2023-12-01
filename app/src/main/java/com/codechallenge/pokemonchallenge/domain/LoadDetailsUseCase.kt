package com.codechallenge.pokemonchallenge.domain

import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepository
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepositoryImpl
import javax.inject.Inject

class LoadDetailsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend operator fun invoke(number :Int) :DetailsResponse{
        return repository.getDetails(number)?:DetailsResponse(0,0)
    }
}