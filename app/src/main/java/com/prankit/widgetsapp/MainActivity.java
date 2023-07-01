package com.prankit.widgetsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner
        Spinner spinner = findViewById(R.id.spinner);
        String[] courses = {"C++", "Java", "Kotlin", "Data Structures"};
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(ad);
        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You Select: "+courses[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        // Time Picker
        Button openTimePicker = findViewById(R.id.btn_time);
        openTimePicker.setOnClickListener(view -> {
            //Display the time picker
            DialogFragment  timePickerFrag = new TimePickerFragment();
            timePickerFrag.show(getSupportFragmentManager(),"Pick Time Now:");
        });


        Button openDatePicker = findViewById(R.id.btn_date);
        openDatePicker.setOnClickListener(view -> {
            DialogFragment dialogFragment = new DatePickerFragment();
            dialogFragment.show(getSupportFragmentManager(),"Pick A Date");
        });

        // Progress bar
        ProgressBar progressBar = findViewById(R.id.progressBar);
        // progressBar.incrementProgressBy()

        Button finalButton = findViewById(R.id.finalBtn);
        finalButton.setOnClickListener(view -> {
            // Increase Progress by 10%
            progressBar.incrementProgressBy(10);
        });

    }
}