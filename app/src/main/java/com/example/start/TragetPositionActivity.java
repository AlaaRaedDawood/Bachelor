package com.example.start;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.List;

import static android.arch.lifecycle.ViewModelProviders.of;

public class TragetPositionActivity extends AppCompatActivity {
    private HiitViewModel hiitViewModel;
    private int height = -1;
    private String backproblems = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_traget_position);
        final int index = getIntent().getIntExtra("index" , -1);
        final int size = getIntent().getIntExtra("size" , -1);
        final targetPosition targetWal  = (targetPosition) findViewById(R.id.targetPosition);
        hiitViewModel = of(this).get(HiitViewModel.class);
        if((index != -1) &&(size != -1)){
            hiitViewModel.getAllProfiles().observe(this , new Observer<List<ProfileTableDb>>() {
                @Override
                public void onChanged(@Nullable List<ProfileTableDb> profiles) {
                    if(profiles.size() != 0){
                        height = profiles.get(0).getUser_height();
                        backproblems = profiles.get(0).getUser_backproblems();
                        targetWal.setShowTarget(index , size , height , backproblems);
                    }
                 }});
            Log.i("alaa" , "kolo tmam");


        }

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
            }});

    }

}
