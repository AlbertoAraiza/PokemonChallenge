package com.codechallenge.pokemonchallenge.di

import com.codechallenge.pokemonchallenge.core.Constants.base_url
import com.codechallenge.pokemonchallenge.data.api.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonService(retrofit :Retrofit) :PokemonService{
        return retrofit.create(PokemonService::class.java)
    }
}