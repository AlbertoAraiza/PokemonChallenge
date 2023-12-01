package com.codechallenge.pokemonchallenge.domain

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShowErrorMessageUseCase @Inject constructor(
    @ApplicationContext private val ctx : Context
){
    operator fun invoke(msg :String){
        Log.e("Error", msg)
        Toasty.error(ctx, msg).show()
    }
}