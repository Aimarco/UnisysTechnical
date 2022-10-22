package com.android.unisystechnical.requests.responses;

import com.android.unisystechnical.model.Pokemon;
import com.android.unisystechnical.requests.Results;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {

    @SerializedName("results")
    @Expose()
    private List<Results> pokemon = null;

    public List<Results> getPokemon(){
        return pokemon;
    }

}
