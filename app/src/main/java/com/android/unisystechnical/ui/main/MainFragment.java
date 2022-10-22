package com.android.unisystechnical.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.unisystechnical.R;
import com.android.unisystechnical.UnisysTechnical;
import com.android.unisystechnical.databinding.FragmentMainBinding;
import com.android.unisystechnical.model.Pokemon;
import com.android.unisystechnical.requests.Results;
import com.android.unisystechnical.requests.responses.PokemonResponse;
import com.android.unisystechnical.ui.adapter.PokemonAdapter;
import com.android.unisystechnical.ui.viewModel.MainViewModel;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private FragmentMainBinding binding;
    private PokemonAdapter pokemonAdapter;
    private RecyclerView pokemonRV;
    private List<Pokemon> pokemonList;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        //binding.setLifecycleOwner(this);
        List<Pokemon> pokemonFullList = new ArrayList<>();
        pokemonRV = binding.getRoot().findViewById(R.id.pokemonRV);
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(requireActivity()).build();
            ImageLoader.getInstance().init(config);
            pokemonAdapter = new PokemonAdapter();
            pokemonRV.setLayoutManager(new LinearLayoutManager(getActivity()));
            pokemonRV.setHasFixedSize(true);

            mViewModel.getPokemonList().observe(requireActivity(), results -> {
                if(results != null){
                    mViewModel.getPokemonDetails(results.getPokemon()).observe(requireActivity(),listaPokemons->{
                        listaPokemons.sort(Comparator.comparing(Pokemon::getId));
                        pokemonAdapter.setPokemons(listaPokemons);
                        pokemonRV.setAdapter(pokemonAdapter);
                    });
                }
            });
            if(mViewModel.getPokemonList().getValue()!=null){

            }
        return binding.getRoot();
    }

}