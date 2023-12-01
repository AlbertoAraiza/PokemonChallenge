package com.codechallenge.pokemonchallenge.ui.screens.pokemon_list

import com.codechallenge.pokemonchallenge.domain.LoadPokemonsUseCase
import com.codechallenge.pokemonchallenge.repositories.FakePokemonRepository
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class PokemonListViewModelTest {
    private lateinit var vm :PokemonListViewModel
    @Before
    fun setUp() {
        vm = PokemonListViewModel(LoadPokemonsUseCase(FakePokemonRepository()))
    }

    @Test
    fun `no internet connection, returns false`(){

    }

    @After
    fun tearDown() {
    }
}