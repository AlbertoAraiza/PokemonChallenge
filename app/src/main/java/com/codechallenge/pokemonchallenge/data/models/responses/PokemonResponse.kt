package com.codechallenge.pokemonchallenge.data.models.responses

import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results") val result: List<Pokemon>
)
