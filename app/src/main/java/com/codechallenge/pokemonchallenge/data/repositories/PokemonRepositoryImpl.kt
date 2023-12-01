package com.codechallenge.pokemonchallenge.data.repositories

import android.util.Log
import com.codechallenge.pokemonchallenge.data.api.PokemonService
import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse
import com.codechallenge.pokemonchallenge.domain.ShowErrorMessageUseCase
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val services :PokemonService,
    private val showError :ShowErrorMessageUseCase
) :PokemonRepository{
    override suspend fun getPokemons(offset :Int?) :List<Pokemon>?{
        try{
            val limit = if (offset == null) null else 20
            val response = services.getPokemons(offset, limit)
            Log.d("Response", response.raw().request().url().toString())
            if (response.isSuccessful){
                return response.body()?.result
            }else{
                showError("Error de red")
            }
        }catch (ex :Exception){
            Log.e("Error", ex.message?:"", ex)
            showError("Error: ${ex.message?:"Desconocido"}")
        }
        return null
    }

    override suspend fun getDetails(number :Int) :DetailsResponse?{
        try {
            val response = services.getDetails(number)
            Log.d("Response", response.raw().request().url().toString())
            if(response.isSuccessful){
                return response.body()
            }else{
                showError("Error de red")
            }
        } catch (ex :Exception){
            Log.e("Error", ex.message?:"", ex)
            showError("Error: ${ex.message?:"Desconocido"}")
        }
        return null
    }
}