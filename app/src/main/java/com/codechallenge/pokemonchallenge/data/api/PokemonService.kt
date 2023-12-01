package com.codechallenge.pokemonchallenge.data.api

import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse
import com.codechallenge.pokemonchallenge.data.models.responses.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("offset") offset :Int?,
        @Query("limit") limit :Int?,
    ) :Response<PokemonResponse>

    @GET("pokemon/{poke_number}/")
    suspend fun getDetails(
        @Path("poke_number") number :Int
    ) :Response<DetailsResponse>
}