package com.example.start;

import android.arch.lifecycle.Observer;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import static android.arch.lifecycle.ViewModelProviders.of;

public class performanceGraphActivity extends AppCompatActivity {
    ArrayList<BarEntry> BARENTRY ;
    ArrayList<String> BarEntryLabels ;
    ArrayList<String> date = new ArrayList<String>() ;
    ArrayList<Integer> heartRate = new  ArrayList<Integer>();
    HiitViewModel hiitViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_graph);
       // hiitViewModel = of(this).get(HiitViewModel.class);
        date = (ArrayList<String>)getIntent().getSerializableExtra("d");
        heartRate = (ArrayList<Integer>)getIntent().getSerializableExtra("hr");
        Log.i("date" , "pp " + date.size());
        //setBorderColor(int color)
        final Animation anime_alpha = AnimationUtils.loadAnimation(this ,R.anim.alpha_button);
        //return back to menu
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                v.startAnimation(anime_alpha);
                finish();
            }});
        BarChart chart = (BarChart) findViewById(R.id.chart);
         chart.setBorderColor(0xfff);
       BARENTRY = new ArrayList<>();

        BarEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();
        Log.i("date" , "pp 2 " + date.size());
        AddValuesToBarEntryLabels();

        BarDataSet Bardataset = new BarDataSet(BARENTRY, "Heart Rate");

        BarData BARDATA = new BarData(BarEntryLabels, Bardataset);
        //chart.setBorderWidth(70);
        chart.setDescription("heartRate");
         Bardataset.setColor(Color.WHITE);

        //Bardataset.setColors(ColorTemplate.PASTEL_COLORS);

        chart.setData(BARDATA);

        chart.animateY(3000);

    }

    public void AddValuesToBARENTRY() {
//        Toast toast = Toast.makeText(getApplicationContext(),
//                " data size  " + date.size(), Toast.LENGTH_SHORT);
//        toast.show();
        checkPerformance();
        Log.i("performance " , " hhhhhhhhhhhhhhhhhhh = " +heartRate.size());
                for (int i = 0; i < date.size(); i++) {
//                    toast = Toast.makeText(getApplicationContext(), "hr =  " + heartRate.get(i)
//                            + " date  " + date.get(i), Toast.LENGTH_SHORT);
//                    toast.show();
                    Log.i("performance " , " hhhhhhhhhhhhhhhhhhh = " +heartRate.get(i));
                    float x = heartRate.get(i) ;
                    BARENTRY.add(new BarEntry(x , i));
                   // BarEntryLabels.add(date.get(i));
                }

//        BARENTRY.add(new BarEntry(2f, 0));
//        BARENTRY.add(new BarEntry(4f, 1));
//        BARENTRY.add(new BarEntry(6f, 2));
//        BARENTRY.add(new BarEntry(8f, 3));
//        BARENTRY.add(new BarEntry(7f, 4));
//        BARENTRY.add(new BarEntry(3f, 5));
//        BARENTRY.add(new BarEntry(10f, 6));

    }

    public void AddValuesToBarEntryLabels(){
        for (int i = 0; i < date.size(); i++) {
//                    toast = Toast.makeText(getApplicationContext(), "hr =  " + heartRate.get(i)
//                            + " date  " + date.get(i), Toast.LENGTH_SHORT);
//                    toast.show();
            float x = heartRate.get(i) ;
            //BARENTRY.add(new BarEntry(x , i));
            BarEntryLabels.add(date.get(i));
        }
//        BarEntryLabels.add("January");
//        BarEntryLabels.add("February");
//        BarEntryLabels.add("March");
//        BarEntryLabels.add("April");
//        BarEntryLabels.add("May");
//        BarEntryLabels.add("June");
//        BarEntryLabels.add("July");
    }
    public void checkPerformance(){

    }
}