package com.codechallenge.pokemonchallenge.domain

import com.codechallenge.pokemonchallenge.data.models.Pokemon
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoadPokemonsUseCaseTest{
    @RelaxedMockK private lateinit var repository: PokemonRepository
    private lateinit var loadPokemons :LoadPokemonsUseCase

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        loadPokemons = LoadPokemonsUseCase(repository)
    }

    @Test
    fun `When repository returns null, get empty list`() = runBlocking{
        //Given
        coEvery { repository.getPokemons(any()) } returns null
        //When
        val result = loadPokemons(0)
        //Then
        assert(result.isEmpty())
    }

    @Test
    fun `when repository returns data, get data`() = runBlocking{
        //Given
        val charmander = Pokemon("Charmander", "test_url")
        val squirtle = Pokemon("Squirtle", "test_url")
        val bulbasaur = Pokemon("Bulbasaur", "test_url")
        val data = listOf(charmander, squirtle, bulbasaur)
        coEvery { repository.getPokemons(any()) } returns data
        //When
        val result = loadPokemons(0)
        //Then
        assert(result.contains(charmander))
        assert(result.contains(squirtle))
        assert(result.contains(bulbasaur))
        assert(result.size == data.size)
    }
}