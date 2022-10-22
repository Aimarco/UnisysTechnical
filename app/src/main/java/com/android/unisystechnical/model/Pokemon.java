package com.android.unisystechnical.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable {
    @SerializedName("height")
    @Expose()
    private int height;

    @SerializedName("id")
    @Expose()
    private int id;

    @SerializedName("sprites")
    @Expose()
    private Sprites sprites = null;

    @SerializedName("name")
    @Expose()
    private String name = null;

    @SerializedName("weight")
    @Expose()
    private int weight = 0;

    private String image;
    private String desc;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc.substring(desc.length()-2,desc.length()-1);;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @NonNull
    @Override
    public String toString() {
        return "Pokemon: "+getName()+ "\n"+"Número: "+getId()+ "\n"+"Peso: "+getWeight()+ "lbs \n"+"Altura: " +getHeight()+"ft";
    }
}
