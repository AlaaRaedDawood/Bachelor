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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;
//the activity that allows the user to choose from the layout that available in db
public class ChooseLayoutActivity extends AppCompatActivity {
    private HiitViewModel hiitViewModel ;
    private layoutTableDB choosenLayout ;
    private int profileSize ;
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
        adapter.setOnItemClickListener(new LayoutAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(layoutTableDB layout) {
                choosenLayout = layout ;
             //   hiitViewModel.delete(layout);
            }
        });
        Button delete_btn = (Button) findViewById(R.id.deleteButton);
        delete_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                hiitViewModel.delete(choosenLayout);
            }});
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
                }

            }});
        hiitViewModel.getAllLayouts().observe(this, new Observer<List<layoutTableDB>>() {
            @Override
            public void onChanged(@Nullable List<layoutTableDB> layouts) {
                adapter.setLayouts(layouts);
            }
        });
    }
    }


