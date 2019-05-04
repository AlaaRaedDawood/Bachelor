package com.example.start;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Region;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FinalLayoutResult extends AppCompatActivity {
    private HiitViewModel hiitViewModel;
    private int profileSize ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //create instance of viewModel
        hiitViewModel = ViewModelProviders.of(this).get(HiitViewModel.class);
        ///
        final ArrayList<PointF> startPoints =(ArrayList<PointF>)getIntent().getSerializableExtra("startPoints"); ;
        final ArrayList<PointF> stopPoints = (ArrayList<PointF>)getIntent().getSerializableExtra("stopPoints");
        final ArrayList<IntersectedPoints> intersectedPoints = (ArrayList<IntersectedPoints>)getIntent().getSerializableExtra("intersectedPoints");
        float[] size = getIntent().getFloatArrayExtra("lineSizes");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_final_layout_result);
        final FinalLayoutPath canvas  = (FinalLayoutPath) findViewById(R.id.result_canvas);
        final targetPosition targetWall  = (targetPosition) findViewById(R.id.targetPosition);
        canvas.setStartPoints(startPoints);
        canvas.setStopPoints(stopPoints);
        canvas.setIntersectPoints(intersectedPoints);
        canvas.setMeasures(size);
        canvas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int xPos = (int) event.getX();
                int yPos = (int)  event.getY();
                ArrayList<Region> regions = canvas.getRegions();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.i("alaa" ,"there is a touch");
                    Log.i("region" , "SIZZZZZZEE sucess" + regions.size());
                    for(int i = 0 ;i< regions.size();i++){
                        if (regions.get(i).contains(xPos, yPos)) {
                            targetWall.setShowTarget(i , canvas.getSize());
                            Log.i("region" , "region is selected" + i);
                            break;
                        }}

                }
                return true;
            }
        });

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText text = new EditText(this);
        final Animation anime_alpha = AnimationUtils.loadAnimation(this ,R.anim.alpha_button);
        Button btn_save = (Button) findViewById(R.id.saveButton);
       // hiitViewModel.deleteAllNotes();
//        hiitViewModel.getAllLayouts().observe(this, new Observer<List<layoutTableDB>>() {
//            @Override
//            public void onChanged(@Nullable List<layoutTableDB> notes) {
//                // Update recycler view
//                //  Toast.makeText(MainActivity.this, "onChanges",Toast.LENGTH_SHORT).show();
//                if (notes.size() > 0) {
//                    Log.i("alaadb", " good " +notes.size());
//
//                }
//            }});
        hiitViewModel.getProfileSize().observe(this , new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer profilesize) {
                profileSize = profilesize ;
                Log.i("DB" , "the profile size is " + profilesize);

            }});
        btn_save.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Log.i("alaa","save button is clicked");
                if(profileSize == 1) {
                    //make alpha animation
                    v.startAnimation(anime_alpha);
                    //show a dialogue that takes from the user the name of the layout
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {


                            builder.setMessage("the name of the layout  ").setView(text);
                            builder.setPositiveButton("DONE",
                                    null);


                            final AlertDialog alert = builder.create();
                            alert.show();
                            alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Boolean flag = (text.getText().toString().trim().isEmpty());
                                    // if EditText is empty disable closing on possitive button
                                    if (!flag) {

                                        String layout_title = text.getText().toString();
                                        layoutTableDB layout = new layoutTableDB(layout_title,canvas.getPlines() ,canvas.getIntersectPointF(),
                                                canvas.getStartPointsPoint(), canvas.getStopPointsPoint(),0);

                                        if (layout != null) {

                                            hiitViewModel.insert(layout);

                                            Log.i("alaa", "layout saved");
                                            returntomainactivity();
                                        }

                                        alert.dismiss();
                                        //start intent that returns to main activity
//                                    finish();
//                                    Intent i = new Intent(FinalLayoutResult.this , MainActivity.class);
//                                    startActivity(i);


                                    }

                                }
                            });


                        }
                    }, 500);


                }else {
                    Toast toast=Toast.makeText(getApplicationContext(),"a profile needed to be saved",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
//
    }
    public void returntomainactivity(){
        Intent intent = new Intent(FinalLayoutResult.this, ChooseLayoutActivity.class);
        startActivity(intent);
    }
}
