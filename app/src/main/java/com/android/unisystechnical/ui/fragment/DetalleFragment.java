package com.android.unisystechnical.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.android.unisystechnical.databinding.DetalleFragmentBinding;
import com.android.unisystechnical.model.Pokemon;
import com.nostra13.universalimageloader.core.ImageLoader;

public class DetalleFragment extends Fragment {
    private DetalleFragmentBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DetalleFragmentBinding.inflate(inflater, container, false);
        if(getArguments()!= null){
            if(getArguments().getSerializable("pokemon") != null){
                Pokemon pokemon = (Pokemon) getArguments().getSerializable("pokemon");
                ImageLoader imageLoader = ImageLoader.getInstance(); // Get singleton instance
                imageLoader.displayImage(pokemon.getSprites().getImage(),binding.pokeImage);
                binding.pokeDesc.setText(pokemon.toString());
                binding.setPokemon(pokemon);
            }
        }
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public String setUpDesc(Pokemon pokemon){
        String descripcion ="";
        descripcion += "Pokemon: "+pokemon.getName()+ "\n"+"Número: "+pokemon.getId()+ "\n"+"Peso: "+pokemon.getWeight()+ "lbs \n"+"Altura: " +pokemon.getHeight()+"ft";
        return descripcion;
    }

}
