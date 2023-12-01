package com.codechallenge.pokemonchallenge.di

import com.codechallenge.pokemonchallenge.data.api.PokemonService
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepository
import com.codechallenge.pokemonchallenge.data.repositories.PokemonRepositoryImpl
import com.codechallenge.pokemonchallenge.domain.ShowErrorMessageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {
    @Provides
    @Singleton
    fun providePokemonRepository(service :PokemonService, showError :ShowErrorMessageUseCase) :PokemonRepository{
        return PokemonRepositoryImpl(service, showError)
    }

}