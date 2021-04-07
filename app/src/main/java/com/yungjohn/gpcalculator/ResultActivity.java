package com.yungjohn.gpcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvGPA = findViewById(R.id.tv_result);

        Intent intent = getIntent();
        String gradePointAvg = intent.getStringExtra(MainActivity.EXTRA_GPA);
        tvGPA.setText(gradePointAvg);
    }
}