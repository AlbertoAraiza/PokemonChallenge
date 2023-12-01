package com.codechallenge.pokemonchallenge.data.models.responses

import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    @SerializedName("height") val height :Int,
    @SerializedName("weight") val weight :Int
)