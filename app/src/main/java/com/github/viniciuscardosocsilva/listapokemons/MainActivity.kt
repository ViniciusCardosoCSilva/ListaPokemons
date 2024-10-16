package com.github.viniciuscardosocsilva.listapokemons

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.github.viniciuscardosocsilva.listapokemons.data.PokemonRepository
import com.github.viniciuscardosocsilva.listapokemons.data.api.ApiClient
import com.github.viniciuscardosocsilva.listapokemons.ui.pokemonlist.MainListAdapter
import com.github.viniciuscardosocsilva.listapokemons.ui.pokemonlist.MainViewModel
import com.github.viniciuscardosocsilva.listapokemons.ui.pokemonlist.MainViewModelFactory
import com.github.viniciuscardosocsilva.listapokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(PokemonRepository(ApiClient.createPokeApiService()))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = MainListAdapter { view, pokemon ->
            Toast.makeText(this, pokemon.name, Toast.LENGTH_LONG).show()
        }
        //binding.pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.pokemonRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.pokemonRecyclerView.adapter = adapter
        viewModel.pokemonList.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}