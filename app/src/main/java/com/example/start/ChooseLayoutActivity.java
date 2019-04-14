package com.example.start;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
//the activity that allows the user to choose from the layout that available in db
public class ChooseLayoutActivity extends AppCompatActivity {
    private HiitViewModel hiitViewModel ;
    private layoutTableDB choosenLayout ;
    private int profileSize ;
    private int layoutSize = 0 ;
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
                layoutSize = layouts.size();
                if(layoutSize > 0){
                adapter.setLayouts(layouts);
            }}
        });
        final Animation anime_alpha = AnimationUtils.loadAnimation(this ,R.anim.alpha_button);

        adapter.setOnItemClickListener(new LayoutAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(layoutTableDB layout) {
                choosenLayout = layout ;
             //   hiitViewModel.delete(layout);
            }

            @Override
            public void onDeleteLayout(layoutTableDB layout , View v) {
                v.startAnimation(anime_alpha);
                hiitViewModel.delete(layout);
            }

            @Override
            public void onViewLayout(layoutTableDB layout, View v) {
                v.startAnimation(anime_alpha);
                Intent intent = new Intent(ChooseLayoutActivity.this , ViewLayoutActivity.class);
                intent.putExtra("layoutTableDb" ,layout);
                startActivity(intent);

            }

        });

        hiitViewModel.getProfileSize().observe(this , new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer profilesize) {
                profileSize = profilesize ;
                Log.i("DB" , "the profile size is " + profilesize);

            }});

        Button add_btn = (Button) findViewById(R.id.addLayoutButton);
        add_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(profileSize == 0){
                    Toast toast=Toast.makeText(getApplicationContext(),"a profile must be saved",Toast.LENGTH_SHORT);
                    // toast.setMargin(50,50);
                    toast.show();
                }else {
                    v.startAnimation(anime_alpha);
                    Intent intent = new Intent(ChooseLayoutActivity.this , DrawLayoutActivity.class);
                    startActivity(intent);
                }

            }});


    }
    }


