package com.android.unisystechnical.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.android.unisystechnical.repositories.PokemonRepository;
import com.android.unisystechnical.requests.Results;
import com.android.unisystechnical.model.Pokemon;
import com.android.unisystechnical.requests.responses.PokemonResponse;

import java.util.List;

public class MainViewModel extends ViewModel {
    private PokemonRepository mPokemonRepository;
    private LiveData<PokemonResponse> pokemonResponseLiveData;
    private LiveData<List<Pokemon>> pokemonList;
    // TODO: Implement the ViewModel
public MainViewModel(){
    mPokemonRepository = PokemonRepository.getInstance();
}

    public LiveData<PokemonResponse> getPokemonList(){
        this.pokemonResponseLiveData = mPokemonRepository.getPokemonList();
        return pokemonResponseLiveData;
    }

    public LiveData<List<Pokemon>> getPokemonDetails(List<Results> resultados){
        this.pokemonList = mPokemonRepository.getPokemonDetails(resultados);
        return this.pokemonList;
    }


}