package com.example.start;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ViewLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_view_layout);
        final ViewLayoutCanvas canvas  = (ViewLayoutCanvas) findViewById(R.id.view_canvas);
        layoutTableDB choosenLayout = (layoutTableDB)getIntent().getSerializableExtra("layoutTableDb");
        canvas.setIntersectPoints(choosenLayout.getIntersectPoints());
        canvas.setStartPoints(choosenLayout.getStartPoints());
        canvas.setStopPoints(choosenLayout.getStopPoints());


    }

}
