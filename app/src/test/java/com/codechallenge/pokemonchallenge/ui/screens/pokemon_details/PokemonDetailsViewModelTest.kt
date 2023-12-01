package com.codechallenge.pokemonchallenge.ui.screens.pokemon_details

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse
import com.codechallenge.pokemonchallenge.domain.LoadDetailsUseCase
import com.codechallenge.pokemonchallenge.domain.LoadPokemonsUseCase
import com.codechallenge.pokemonchallenge.ui.navigation.AppScreens
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PokemonDetailsViewModelTest {
    @get:Rule
    var rule :InstantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK private lateinit var loadDetails : LoadDetailsUseCase
    private lateinit var viewmodel :PokemonDetailsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewmodel = PokemonDetailsViewModel(loadDetails)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `load data from the pokemon number`() = runBlocking{
        //Given
        val testNumber = 10
        val details = DetailsResponse(testNumber, testNumber)
        coEvery { loadDetails(any()) } returns details

        //When
        viewmodel.loadData(testNumber)

        //Then
        assert(viewmodel.pokeNumber.contains(testNumber.toString()) )
        assert(viewmodel.pokeHeight.contains(testNumber.toString()))
        assert(viewmodel.pokeWeight.contains((testNumber / 10f).toString()))
    }
}