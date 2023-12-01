package com.codechallenge.pokemonchallenge.domain

import com.codechallenge.pokemonchallenge.data.models.responses.DetailsResponse
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class LoadDetailsUseCaseTest {
    @RelaxedMockK
    private lateinit var repository :PokemonRepository
    private lateinit var loadDetails :LoadDetailsUseCase
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        loadDetails = LoadDetailsUseCase(repository)
    }

    @Test
    fun `when load details return null, then get default values`() = runBlocking{
        //Given
        coEvery { repository.getDetails(any()) } returns null

        //WHen
        val details = loadDetails(0)

        //Then
        assert(details == DetailsResponse(0,0))
    }

    @Test
    fun `when load details return data, then get the data`() = runBlocking {
        //Given
        val data = DetailsResponse(10,10)
        coEvery { repository.getDetails(any()) } returns data

        //When
        val result = loadDetails(0)

        //Then
        assert(data == result)
    }

    @After
    fun tearDown() {

    }
}