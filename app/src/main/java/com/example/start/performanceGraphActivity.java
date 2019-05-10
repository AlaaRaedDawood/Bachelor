package com.example.start;

import android.arch.lifecycle.Observer;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_performance_graph);
        hiitViewModel = of(this).get(HiitViewModel.class);

       // date = (ArrayList<String>)getIntent().getSerializableExtra("d");
        //heartRate = (ArrayList<Integer>)getIntent().getSerializableExtra("hr");
        Log.i("performance" , "in graph activity the size is " + date.size());
        //setBorderColor(int color)
        final Animation anime_alpha = AnimationUtils.loadAnimation(this ,R.anim.alpha_button);
        //return back to menu
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                v.startAnimation(anime_alpha);
                finish();
            }});
        hiitViewModel.getAllPerformance().observe(performanceGraphActivity.this, new Observer<List<PerformanceTableDB>>() {
            @Override
            public void onChanged(@Nullable List<PerformanceTableDB> performances) {
                BarChart chart = (BarChart) findViewById(R.id.chart);
                chart.setBorderColor(0xfff);

                BARENTRY = new ArrayList<>();

                BarEntryLabels = new ArrayList<String>();

                // AddValuesToBARENTRY();
                Log.i("date" , "pp 2 " + date.size());
                //  AddValuesToBarEntryLabels();
                for (int i=0 ; i < performances.size();i++){
                    float heartRate = performances.get(i).getUser_heartRate();
                    String date = performances.get(i).getDate();
                    AddValuesToBARENTRY(heartRate,i);
                    AddValuesToBarEntryLabels(date);
                }
//                for(int i = 0 ; i < 40 ; i++){
//                    AddValuesToBARENTRY(20+i,i);
//                    AddValuesToBarEntryLabels("alaa");
//                }

                BarDataSet Bardataset = new BarDataSet(BARENTRY, "Heart Rate");
                //Bardataset.setBarSpacePercent((float) 0.01);
                BarData BARDATA = new BarData(BarEntryLabels, Bardataset);
                //chart.setBorderWidth(70);
                chart.setDescription("heartRate");
                Bardataset.setColor(Color.WHITE);

                //Bardataset.setColors(ColorTemplate.PASTEL_COLORS);

                chart.setData(BARDATA);
                chart.setVisibleXRangeMaximum(5);
                chart.animateY(3000);

            }

        });
//        BarChart chart = (BarChart) findViewById(R.id.chart);
//         chart.setBorderColor(0xfff);
//       BARENTRY = new ArrayList<>();
//
//        BarEntryLabels = new ArrayList<String>();
//
//       // AddValuesToBARENTRY();
//        Log.i("date" , "pp 2 " + date.size());
//      //  AddValuesToBarEntryLabels();
//
//        BarDataSet Bardataset = new BarDataSet(BARENTRY, "Heart Rate");
//
//        BarData BARDATA = new BarData(BarEntryLabels, Bardataset);
//        //chart.setBorderWidth(70);
//        chart.setDescription("heartRate");
//         Bardataset.setColor(Color.WHITE);
//
//        //Bardataset.setColors(ColorTemplate.PASTEL_COLORS);
//
//        chart.setData(BARDATA);
//
//        chart.animateY(3000);

    }

//    public void AddValuesToBARENTRY() {
//
//        BARENTRY.clear();
//        Log.i("performance " , " hhhhhhhhhhhhhhhhhhh = " +heartRate.size());
//                for (int i = 0; i < date.size(); i++) {
//                    Log.i("performance ", " hhhhhhhhhhhhhhhhhhh = " + heartRate.get(i));
//                    float x = heartRate.get(i);
//                    BARENTRY.add(new BarEntry(x, i));
//
//                }
//
//    }
//
//    public void AddValuesToBarEntryLabels(){
//        BarEntryLabels.clear();
//        for (int i = 0; i < date.size(); i++) {
//
//            BarEntryLabels.add(date.get(i));
//        }
//
//    }
public void AddValuesToBARENTRY(float heartrate , int i) {

    //BARENTRY.clear();
    Log.i("performance " , " hhhhhhhhhhhhhhhhhhh = " + heartrate);
    BARENTRY.add(new BarEntry(heartrate, i));



}

    public void AddValuesToBarEntryLabels(String date){

        Log.i("performance " , " hhhhhhhhhhhhhhhhhhh = " + date);
        BarEntryLabels.add(date);


    }
}