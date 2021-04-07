package com.yungjohn.gpcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_GPA = "com.yungjohn.gpcalculator.GPA";

    private EditText mUnit1;
    private EditText mUnit2;
    private EditText mUnit3;
    private EditText mUnit4;
    private EditText mUnit5;
    private EditText mUnit6;
    private EditText mUnit7;

    private EditText mGrade1;
    private EditText mGrade2;
    private EditText mGrade3;
    private EditText mGrade4;
    private EditText mGrade5;
    private EditText mGrade6;
    private EditText mGrade7;
    private double mGradePointAvg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGrade1 = findViewById(R.id.edit_grade_1);
        mGrade2 = findViewById(R.id.edit_grade_2);
        mGrade3 = findViewById(R.id.edit_grade_3);
        mGrade4 = findViewById(R.id.edit_grade_4);
        mGrade5 = findViewById(R.id.edit_grade_5);
        mGrade6 = findViewById(R.id.edit_grade_6);
        mGrade7 = findViewById(R.id.edit_grade_7);


        mUnit1 = findViewById(R.id.edit_unit_1);
        mUnit2 = findViewById(R.id.edit_unit_2);
        mUnit3 = findViewById(R.id.edit_unit_3);
        mUnit4 = findViewById(R.id.edit_unit_4);
        mUnit5 = findViewById(R.id.edit_unit_5);
        mUnit6 = findViewById(R.id.edit_unit_6);
        mUnit7 = findViewById(R.id.edit_unit_7);

        Button button = findViewById(R.id.bt_calc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                String extraGPA = String.valueOf(mGradePointAvg);
                if (extraGPA == null) {
                    Toast.makeText(MainActivity.this, getString(R.string.null_input_error_message), Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra(EXTRA_GPA, extraGPA);
                    startActivity(intent);
                }
            }
        });
    }


    public void calculate() {
        int unit1 = 0;
        int unit2 = 0;
        int unit3 = 0;
        int unit4 = 0;
        int unit5 = 0;
        int unit6 = 0;
        int unit7 = 0;

        try {
            unit1 = Integer.parseInt(mUnit1.getText().toString());
            unit2 = Integer.parseInt(mUnit2.getText().toString());
            unit3 = Integer.parseInt(mUnit3.getText().toString());
            unit4 = Integer.parseInt(mUnit4.getText().toString());
            unit5 = Integer.parseInt(mUnit5.getText().toString());
            unit6 = Integer.parseInt(mUnit6.getText().toString());
            unit7 = Integer.parseInt(mUnit7.getText().toString());

        } catch (NullPointerException npe) {
            Log.d("MainActivity", "Error: " + npe);
        }
        int grade1 = convert(mGrade1.getText().toString());
        int gradePoint1 = grade1 * unit1;

        int grade2 = convert(mGrade2.getText().toString());
        int gradePoint2 = grade2 * unit2;

        int grade3 = convert(mGrade3.getText().toString());
        int gradePoint3 = grade3 * unit3;

        int grade4 = convert(mGrade4.getText().toString());
        int gradePoint4 = grade4 * unit4;

        int grade5 = convert(mGrade5.getText().toString());
        int gradePoint5 = grade5 * unit5;

        int grade6 = convert(mGrade6.getText().toString());
        int gradePoint6 = grade6 * unit6;

        int grade7 = convert(mGrade7.getText().toString());
        int gradePoint7 = grade7 * unit7;

        int totalUnit = unit1 + unit2 + unit3 + unit4 + unit5 + unit6 + unit7;
        double totalGradePoint = gradePoint1 + gradePoint2 + gradePoint3 + gradePoint4 + gradePoint5 + gradePoint6 + gradePoint7;
        mGradePointAvg = totalGradePoint / totalUnit;
    }

    //This method converts a particular grade(char) to its corresponding grade value(number)
    public static int convert(String grade){
        switch (grade){
            //A = 5; B = 4; C = 3; D = 2; E = 1; F = 0;
            case "A": return 5;
            case "B": return 4;
            case "C": return 3;
            case "D": return 2;
            case "E": return 1;
            case "F": return 0;
            default: return -1;
        }
    }
}