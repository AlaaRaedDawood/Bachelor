package com.example.start;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ViewLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_layout);
        final ViewLayoutCanvas canvas  = (ViewLayoutCanvas) findViewById(R.id.view_canvas);
        layoutTableDB choosenLayout = (layoutTableDB)getIntent().getSerializableExtra("layoutTableDb");
        canvas.setIntersectPoints(choosenLayout.getIntersectPoints());
        canvas.setStartPoints(choosenLayout.getStartPoints());
        canvas.setStopPoints(choosenLayout.getStopPoints());


    }

}
