package com.android.unisystechnical.repositories;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.unisystechnical.model.Pokemon;
import com.android.unisystechnical.requests.responses.PokemonResponse;
import com.android.unisystechnical.retrofit.Api;
import com.android.unisystechnical.requests.Results;
import com.android.unisystechnical.retrofit.RetrofitRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonRepository {

    private static PokemonRepository instance;
    private Api mPokemonApi;
    private String mQuery;
    private MediatorLiveData<List<Results>> mResults = new MediatorLiveData<>();

    public static PokemonRepository getInstance(){
        if(instance == null){
            instance = new PokemonRepository();
        }
        return instance;
    }

    private PokemonRepository(){
        mPokemonApi = RetrofitRequest.getRetrofitInstance().create(Api.class);
    }
    public LiveData<PokemonResponse> getPokemonList(){
        final MutableLiveData<PokemonResponse> data = new MutableLiveData<>();
        mPokemonApi.getPokemons()
                .enqueue(new Callback<PokemonResponse>() {


                    @Override
                    public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                        Log.d("TAG", "onResponse response:: " + response);
                        if (response.body() != null) {
                            data.setValue(response.body());
                            Log.d("TAG", "articles total result:: " + response.body());
                            Log.d("TAG", "articles size:: " + response.body());
                            Log.d("TAG", "articles title pos 0:: " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<PokemonResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public LiveData<List<Pokemon>> getPokemonDetails(List<Results> resultados){
        final MutableLiveData<List<Pokemon>> data = new MutableLiveData<>();
        List<Pokemon> pokemonList = new ArrayList<>();
        for(int i =0;i<resultados.size();i++){
            mPokemonApi.getPokemonDetails(resultados.get(i).getPokeName())
                    .enqueue(new Callback<Pokemon>() {
                        @Override
                        public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                            Log.d("TAG", "onResponse response:: " + response);
                            if (response.body() != null) {
                                pokemonList.add(response.body());
                                Log.d("TAG", "articles total result:: " + response.body());
                                Log.d("TAG", "articles size:: " + response.body());
                                Log.d("TAG", "articles title pos 0:: " + response.body());
                            }
                            data.postValue(pokemonList);
                        }

                        @Override
                        public void onFailure(Call<Pokemon> call, Throwable t) {
                            pokemonList.add(null);
                            data.postValue(pokemonList);
                        }
                    });
        }

        return data;
    }
}




