package com.example.start;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.alaa.arhiit.UnityPlayerActivity;

import java.nio.BufferUnderflowException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.arch.lifecycle.ViewModelProviders.of;

public class MainActivity extends AppCompatActivity {
    private HiitViewModel hiitViewModel ;
    private int performanceCount ;
    private ArrayList<PathLine> layoutpaths = new ArrayList<>() ;
    private int maxheartrate ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hiitViewModel = of(this).get(HiitViewModel.class);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        CoordinatorLayout constraintLayout = (CoordinatorLayout)findViewById(R.id.mainLayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        final Animation anime_translate = AnimationUtils.loadAnimation(this ,R.anim.anime_translate);

        Button buttonPerformance = (Button)(findViewById(R.id.button_performance));
        buttonPerformance.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                v.startAnimation(anime_translate);
                Intent i = new Intent(MainActivity.this , performanceGraphActivity.class);
                startActivity(i);

            }
        });
        checkProfile();
        checkPerformanceCount();
        Button buttonTrial = (Button)(findViewById(R.id.button_trial));
        Button buttonPlay = (Button)(findViewById(R.id.button_play));
        if(performanceCount == 0){
            buttonTrial.setVisibility(View.VISIBLE);
            buttonPlay.setVisibility(View.GONE);
        }else {
            buttonPlay.setVisibility(View.VISIBLE);
            buttonTrial.setVisibility(View.GONE);
        }
        buttonTrial.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final View view = v;

                hiitViewModel.getAllLayouts().observe(MainActivity.this, new Observer<List<layoutTableDB>>() {
                    @Override
                    public void onChanged(@Nullable List<layoutTableDB> layouts) {
                        for(int i = 0 ; i < layouts.size() ; i++){
                            if(layouts.get(i).getUsed() ==1){
                                layoutpaths = layouts.get(i).getPathLines();
                                Log.i("aaaaaaaaaaaaaaaaaaa" , "layoutpath used is " +layouts.get(i).getUsed() );
                                Log.i("aaaaaaaaaaaaaaaaaaa" , "layoutpath size is " +layouts.get(i).getPathLines().size() );

                                Log.i("aaaaaaaaaaaaaaaaaaa" , "layout in path size is " +layoutpaths.size() );
                                break;
                            }
                        }



                        if(layoutpaths.size() != 0) {
                            if (layoutpaths != null) {
                                int[] point1ID = new int[layoutpaths.size()];;
                                int[] point2ID = new int[layoutpaths.size()];
                                float[] size = new float[layoutpaths.size()];
                                Log.i("aaaaaaaaaaaaaaaaaaaaaa", "layout size is " + layoutpaths.size());
                                for (int i = 0; i < layoutpaths.size(); i++) {
                                    Log.i("PATHLINE", "layout point1ID is " + layoutpaths.get(i).getPoint1ID() + " point2ID "
                                    + layoutpaths.get(i).getPoint2ID() +" size is " + layoutpaths.get(i).getSize());
                                    point1ID[i] = layoutpaths.get(i).getPoint1ID();
                                    point2ID[i] = layoutpaths.get(i).getPoint2ID();
                                    size[i] = layoutpaths.get(i).getSize();
                                }
                                //profiles.get(0).getBirthdate();
                                Log.i("aaaaaaaaaaaaaaaaaaaaaa " , " point1ID " + point1ID[0]);
                                view.startAnimation(anime_translate);
                                Intent intent = new Intent(MainActivity.this, UnityPlayerActivity.class);
                                intent.putExtra("maxheartRate", maxheartrate);
                                intent.putExtra("point1ID", point1ID);
                                intent.putExtra("point2ID", point2ID);
                                intent.putExtra("size", size);
                                intent.putExtra("flag", 0);
                                //startActivityForResult(intent, 1);
                                startActivity(intent);
                            }

                        }
                    }});
            }});

        buttonPlay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final View view = v;

                hiitViewModel.getAllLayouts().observe(MainActivity.this, new Observer<List<layoutTableDB>>() {
                    @Override
                    public void onChanged(@Nullable List<layoutTableDB> layouts) {
                        for(int i = 0 ; i < layouts.size() ; i++){
                            if(layouts.get(i).getUsed() ==1){
                                layoutpaths = layouts.get(i).getPathLines();
                                Log.i("aaaaaaaaaaaaaaaaaaa" , "layoutpath used is " +layouts.get(i).getUsed() );
                                Log.i("aaaaaaaaaaaaaaaaaaa" , "layoutpath size is " +layouts.get(i).getPathLines().size() );

                                Log.i("aaaaaaaaaaaaaaaaaaa" , "layout in path size is " +layoutpaths.size() );
                                break;
                            }
                        }



                if(layoutpaths.size() != 0) {
                    if (layoutpaths != null) {
                        int[] point1ID = new int[layoutpaths.size()];;
                        int[] point2ID = new int[layoutpaths.size()];
                        float[] size = new float[layoutpaths.size()];
                        Log.i("aaaaaaaaaaaaaaaaaaaaaa", "layout size is " + layoutpaths.size());
                        for (int i = 0; i < layoutpaths.size(); i++) {
                            Log.i("aaaaaaaaaaaaaaaaaaaaaa", "layout size is " + layoutpaths.get(i).getPoint1ID());
                            point1ID[i] = layoutpaths.get(i).getPoint1ID();
                            point2ID[i] = layoutpaths.get(i).getPoint2ID();
                            size[i] = layoutpaths.get(i).getSize();
                        }
                        //profiles.get(0).getBirthdate();
                        Log.i("aaaaaaaaaaaaaaaaaaaaaa " , " point1ID " + point1ID[0]);
                            view.startAnimation(anime_translate);
                            Intent intent = new Intent(MainActivity.this, UnityPlayerActivity.class);
                            intent.putExtra("maxheartRate", maxheartrate);
                            intent.putExtra("point1ID", point1ID);
                            intent.putExtra("point2ID", point2ID);
                            intent.putExtra("size", size);
                            // startActivityForResult(intent, 1);
                            startActivity(intent);
                    }

                }
                    }});
            }});

        Button buttonProfile = (Button)(findViewById(R.id.button_profile));
        buttonProfile.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                v.startAnimation(anime_translate);
                Intent i = new Intent(MainActivity.this , profileActivity.class);
                startActivity(i);

            }
        });
        Button buttonChooseLayout = (Button)(findViewById(R.id.button_chooseLayout));
        buttonChooseLayout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                v.startAnimation(anime_translate);
                Intent i = new Intent(MainActivity.this , ChooseLayoutActivity.class);
                startActivity(i);

            }
        });

    }
    public void checkPerformanceCount(){
        hiitViewModel.getPerformanceSize().observe(this , new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer performanceSize) {
                performanceCount = performanceSize ;
                Log.i("DB" , "the profile size is " + performanceSize);

            }});
    }
    public void checkProfile(){
        hiitViewModel.getAllProfiles().observe(MainActivity.this, new Observer<List<ProfileTableDb>>() {
            @Override
            public void onChanged(@Nullable List<ProfileTableDb> profiles) {

                if (profiles.size() == 0) {
                    Toast toast = Toast.makeText(getApplicationContext(), "save your profile to be able to play", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    int age = -1;
                    //int maxheartRate = 0;
                    try {
                        Log.i("aaaaaaaaaaaaaaaaaaaaaa ", " birthdate is  " + profiles.get(0).getBirthdate());
                        Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(profiles.get(0).getBirthdate());
                        Date today = Calendar.getInstance().getTime();
                        Date date; // your date
                        Calendar cal = Calendar.getInstance();
                        // cal.setTime(date);
                        int year = cal.get(Calendar.YEAR);
                        Log.i("aaaaaaaaaaaaaaaaaa", "cal year is " + year);
                        Log.i("aaaaaaaaaaaaaaaaaa", "year is " + today.getYear());
                        Log.i("aaaaaaaaaaaaaaaaaa", "difference year is " + (year - birthdate.getYear()));
                        int month = cal.get(Calendar.MONTH);
                        int day = cal.get(Calendar.DAY_OF_MONTH);
                        if (today.getMonth() == birthdate.getMonth()) {
                            if (today.getDay() < birthdate.getDay()) {
                                age = (today.getYear() - birthdate.getYear()) ;
                            } else {
                                age = (today.getYear() - birthdate.getYear()) + 1;
                            }
                        } else if ((today.getMonth() < birthdate.getMonth()) && (age == -1)) {
                            age = (today.getYear() - birthdate.getYear()) +1 ;
                        } else if (age == -1) {
                            age = (today.getYear() - birthdate.getYear())+1;
                        }
                    } catch (ParseException e) {
                        Log.i("Error", "birthdate was not saved in right format");
                        e.printStackTrace();
                    }
                    if (age != -1) {
                        if (profiles.get(0).getUser_gender().equals("female")) {
                            maxheartrate = (int) (206.9 - (0.67 * age));
                            Log.i("aaaaaaaaaaaaaaaaaaaaaa ", "age" + age + " heart rate " + maxheartrate);
                        } else {
                            maxheartrate = (int) (206.9 - (0.88 * age));
                        }

                    }
                }
            }
        });

    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
