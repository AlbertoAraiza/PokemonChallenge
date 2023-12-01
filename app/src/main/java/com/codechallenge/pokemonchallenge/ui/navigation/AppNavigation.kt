package com.codechallenge.pokemonchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codechallenge.pokemonchallenge.ui.screens.pokemon_details.PokemonDetailsScreen
import com.codechallenge.pokemonchallenge.ui.screens.pokemon_list.PokemonListScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreens.PokemonList.route){
        composable(route = AppScreens.PokemonList.route){
            PokemonListScreen(navController)
        }
        composable(route = AppScreens.PokemonDetails.route + "?pokeName={pokeName}&pokeNumber={pokeNumber}",
        arguments = listOf(
            navArgument("pokeName"){
                nullable = false
                defaultValue = ""
                type = NavType.StringType
            }, navArgument("pokeNumber"){
                nullable = false
                defaultValue = 0
                type = NavType.IntType
            }
        )){
            PokemonDetailsScreen(navController, pokemon = it.arguments?.getString("pokeName"), number = it.arguments?.getInt("pokeNumber"))
        }
    }
}

/*
* composable(route = AppScreens.JobScreen.route + "?phoneNumber={phoneNumber}&jobId={jobId}",
            arguments = listOf(
                navArgument("phoneNumber"){
                nullable = true
                defaultValue = null
                type = NavType.StringType
            },
                navArgument("jobId"){
                nullable = true
                defaultValue = null
                type = NavType.StringType
            })){
            Log.d("PRUEBA", "phoneNumber: ${it.arguments?.getString("phoneNumber")}")
            Log.d("PRUEBA", "jobId: ${it.arguments?.getString("jobId")}")
            JobScreen( phoneNumber = it.arguments?.getString("phoneNumber"), jobId = it.arguments?.getString("jobId"))
        }*/