package com.android.unisystechnical.requests;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("name")
    private String pokeName;
    @SerializedName("url")
    private String pokeUrl;


    public Results(String name) {
        this.pokeName = name;
    }

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public String getPokeUrl() {
        return pokeUrl;
    }

    public void setPokeUrl(String pokeUrl) {
        this.pokeUrl = pokeUrl;
    }
}