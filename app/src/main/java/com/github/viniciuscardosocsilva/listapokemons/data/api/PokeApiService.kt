package com.github.viniciuscardosocsilva.listapokemons.data.api

import com.github.viniciuscardosocsilva.listapokemons.data.api.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResponse
}