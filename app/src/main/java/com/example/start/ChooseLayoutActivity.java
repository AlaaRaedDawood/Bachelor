package com.example.start;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

public class ChooseLayoutActivity extends AppCompatActivity {
    private HiitViewModel hiitViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_layout);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final LayoutAdapter adapter = new LayoutAdapter();
        recyclerView.setAdapter(adapter);

        hiitViewModel = ViewModelProviders.of(this).get(HiitViewModel.class);
        hiitViewModel.getAllLayouts().observe(this, new Observer<List<layoutTableDB>>() {
            @Override
            public void onChanged(@Nullable List<layoutTableDB> layouts) {
                adapter.setLayouts(layouts);
            }
        });
    }
    }


