package com.android.unisystechnical.ui.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.android.unisystechnical.R;
import com.android.unisystechnical.UnisysTechnical;
import com.android.unisystechnical.model.Pokemon;
import com.android.unisystechnical.ui.fragment.DetalleFragment;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {
    private List<Pokemon> pokemons = new ArrayList<>();


    @Override
    public PokemonHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_row,
                parent, false);
        return new PokemonHolder(itemView);
    }

    @Override
    public void onBindViewHolder( PokemonHolder holder, int position) {
        // Create global configuration and initialize ImageLoader with this config
        ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance
        DisplayImageOptions options = new DisplayImageOptions
                .Builder()
                // stub image will display when your
                // image is loading
                .showStubImage(
                        R.drawable.ic_launcher_foreground)
                // below image will be displayed when
                // the image url is empty
                .showImageForEmptyUri(
                        R.drawable.ic_launcher_background)
                // cachememory method will caches the
                // image in users external storage
                .cacheInMemory()
                // cache on disc will caches the image
                // in users internal storage
                .cacheOnDisc()
                // build will build the view for
                // displaying image..
                .build();
        Pokemon currentPokemon = pokemons.get(position);
        imageLoader.displayImage(currentPokemon.getSprites().getImage(),holder.img_pokemon,options);
        String upperString = currentPokemon.getName().substring(0, 1).toUpperCase() + currentPokemon.getName().substring(1).toLowerCase();
        holder.pokeDesc.setText(upperString);
        holder.itemView.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
// view is from onClick listener in my case
            Bundle bundle = new Bundle();
            bundle.putSerializable("pokemon", currentPokemon);
            Navigation.findNavController(view).navigate(R.id.DetalleAction, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }

    class PokemonHolder extends RecyclerView.ViewHolder {
        private final ImageView img_pokemon;
        private final TextView pokeDesc;

        public PokemonHolder( View itemView) {
            super(itemView);
            img_pokemon = itemView.findViewById(R.id.imgPokemon);
            pokeDesc = itemView.findViewById(R.id.tvName);

        }
    }

}

