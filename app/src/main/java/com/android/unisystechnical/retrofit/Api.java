package com.android.unisystechnical.retrofit;

import com.android.unisystechnical.model.Pokemon;
import com.android.unisystechnical.requests.responses.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon?limit=10&offset=0")
    Call<PokemonResponse> getPokemons();

    @GET("pokemon/{x}")
    Call<Pokemon> getPokemonDetails(@Path("x") String name);

}