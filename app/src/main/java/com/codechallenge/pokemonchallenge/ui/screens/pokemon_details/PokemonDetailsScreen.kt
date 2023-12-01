package com.codechallenge.pokemonchallenge.ui.screens.pokemon_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailsScreen(navController :NavHostController,pokemon :String?, number :Int?, vm :PokemonDetailsViewModel = hiltViewModel()){
    if(pokemon == null || number == null) navController.navigateUp()

    vm.loadData(number!!)
    Scaffold(topBar = {
        TopAppBar(title = { Text(pokemon?.uppercase()?:"BULBASAUR") },
            navigationIcon = { IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back button")
            }})
    }){
        PokemonDetailsBodyContent(it, vm)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailsBodyContent(padding :PaddingValues, vm :PokemonDetailsViewModel) {
    var textValue by remember{ mutableStateOf("")}
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .padding(padding),
    horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = vm.pokeNumber, onValueChange = {}, label = { Text(
            text = "Order number"
        )})
        OutlinedTextField(value = vm.pokeHeight, onValueChange = {}, label = { Text(
            text = "Height"
        )})
        OutlinedTextField(value = vm.pokeWeight, onValueChange = {}, label = { Text(
            text = "Weight"
        )})
    }
}