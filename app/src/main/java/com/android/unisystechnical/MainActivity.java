package com.android.unisystechnical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.android.unisystechnical.requests.Results;
import com.android.unisystechnical.ui.main.MainFragment;
import com.android.unisystechnical.ui.viewModel.MainViewModel;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mViewModel;
    MaterialToolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(
                R.id.nav_host_fragment);
        //Find the NavController
        NavController navController = navHostFragment.getNavController();
        //Setup the Toolbar and NavControllerwith the specified configuration
        NavigationUI.setupWithNavController(toolbar,navController);
    }
}