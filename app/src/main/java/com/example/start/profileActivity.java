package com.example.start;

import android.app.DatePickerDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static android.arch.lifecycle.ViewModelProviders.*;

public class profileActivity extends AppCompatActivity {
private Button button_back ;
private HiitViewModel hiitViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final Animation anime_alpha = AnimationUtils.loadAnimation(this ,R.anim.alpha_button);
        //return back to menu
        button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                v.startAnimation(anime_alpha);
                finish();
            }});
        final Calendar calender = Calendar.getInstance();
        final EditText birthdate_editText = (EditText)findViewById(R.id.editText_birthdateText) ;
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODdateO Auto-generated method stub
                calender.set(Calendar.YEAR, year);
                calender.set(Calendar.MONTH, monthOfYear);
                calender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                birthdate_editText.setText(sdf.format(calender.getTime()));
            }

        };
        //SetBirthdate

        birthdate_editText.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                new DatePickerDialog(profileActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,date , calender
                        .get(Calendar.YEAR), calender.get(Calendar.MONTH),
                        calender.get(Calendar.DAY_OF_MONTH)).show();

            }});

        hiitViewModel = of(this).get(HiitViewModel.class);
   final Button btn_save = (Button)findViewById(R.id.button_save);
   final Button btn_edit = (Button)findViewById(R.id.button_edit);
    btn_save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         String name = ((EditText)findViewById(R.id.editText_profile_name)).getText().toString();
         String birthdate = ((EditText)findViewById(R.id.editText_birthdateText)).getText().toString();
         String gender ;
            RadioButton female_rb= (RadioButton) findViewById(R.id.female_radio_btn);
            RadioButton male_rb= (RadioButton) findViewById(R.id.male_radio_btn);
         if(female_rb.isChecked()){
             gender = "female" ;
         }else {
             gender = "male";
         }
         //create new Profile
         ProfileTableDb profile = new ProfileTableDb(name,gender,birthdate);
         hiitViewModel.insertProfile(profile);
        }
    });

         hiitViewModel.getAllProfiles().observe(this , new Observer<List<ProfileTableDb>>() {
             @Override
             public void onChanged(@Nullable List<ProfileTableDb> profiles) {

                 if(profiles.size() == 0){
                     Log.i("alaa" ,"gamdaaa");

                     btn_edit.setVisibility(View.GONE);
                 }else{
                     btn_edit.setVisibility(View.VISIBLE);
                     btn_save.setVisibility(View.GONE);
                 }

             }
         });

         //int profileSize = hiitViewModel.getProfileSize();
       // int p = 0 ;






    }

}
