package com.codechallenge.pokemonchallenge.ui.screens.pokemon_list

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.codechallenge.pokemonchallenge.R
import com.codechallenge.pokemonchallenge.ui.screens.pokemon_details.PokemonDetailsBodyContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(navController :NavHostController, vm :PokemonListViewModel = hiltViewModel()){
    Scaffold(topBar = {
        TopAppBar(title = { Text("POKEMON CODECHALLENGE") })
    }) {
        ListBodyContent(navController, vm, it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListBodyContent(navController :NavHostController, vm :PokemonListViewModel, padding :PaddingValues){
    val scrollState = rememberLazyListState()
    val isAtBottom = !scrollState.canScrollForward

    LazyColumn(modifier = Modifier.fillMaxWidth(1f).padding(padding),
    state = scrollState){
        items(vm.pokemons.size){
            vm.pokemons[it].let { pokemon->
                ListItem(
                    modifier = Modifier.clickable { navController.navigate(vm.detailsPokemon(pokemon))  },
                    headlineText = {
                        Row(modifier = Modifier.fillMaxWidth(1f)) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_pokeball),
                                contentDescription = "Pokeball icon"
                            )
                            Text(pokemon.name)
                        }
                    },
                    shadowElevation = 2.dp,
                    tonalElevation = 8.dp
                )
            }
        }
    }
    LaunchedEffect(isAtBottom){
        if(isAtBottom)
            vm.loadMore()
        Log.d("PokemonList", "Limit reached")
    }
}

fun LazyListState.isScrolledToEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1