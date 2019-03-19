package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView vText;
    TextView vText1;
    TextView vText2;
    TextView vText3;
    TextView vText4;
    TextView txt1;
    TextView txt2;
    EditText inputText;
    EditText inputText2;
    EditText inputText3;
    Button button1;
    Button button2;
    //Button button_tugas1;
    String word;
    String word1;
    String word2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void task1(View view){
        setContentView(R.layout.activity_main_task1);

        vText = findViewById(R.id.vText);
        txt1 = findViewById(R.id.txt1);
        inputText = findViewById(R.id.inputText);
        button1 = findViewById(R.id.button1);

        vText2 = findViewById(R.id.vText2);
        txt2 = findViewById(R.id.txt2);
        inputText2 = findViewById(R.id.inputTextTB);
        inputText3 = findViewById(R.id.inputTextBB);
        button2 = findViewById(R.id.button2);
    }

    public void showToast(View view) {
        vText = (TextView) findViewById(R.id.inputText);
        word = vText.getText().toString();

        vText1 = (TextView) findViewById(R.id.txt1);
        vText1.setText(word);
    }

    public void showToast2(View view){
        //height
        word1 = inputText2.getText().toString();
        //weight
        word2 = inputText3.getText().toString();

        Float var1 = Float.valueOf(word1);
        Float var3 = var1 * var1;

        Float bmi = Float.valueOf(word2)/var3;

        vText4 = (TextView) findViewById(R.id.txt2);
        vText4.setText(String.valueOf(bmi));

        if (bmi < 18.4){
            tampilText4.setText(String.valueOf(bmi)+" Underweight");
        }
        else if (bmi >= 18.5 && bmi <= 24.9){
            tampilText4.setText(String.valueOf(bmi)+" Normalweight");
        }
        else if (bmi >= 25 && bmi <= 29.9){
            tampilText4.setText(String.valueOf(bmi)+" Overweight");
        }
        else if (bmi >= 30 && bmi <= 34.9){
            tampilText4.setText(String.valueOf(bmi)+" Obesity lvl1");
        }
        else if (bmi >= 35 && bmi <= 39.9){
            tampilText4.setText(String.valueOf(bmi)+" Obesity lvl2");
        }
        else {
            tampilText4.setText(String.valueOf(bmi)+" Obesity lvl3");
        }

    }

    public void task2(View view) {
        setContentView(R.layout.activity_main_task2);
    }

    public void tugas3(View view) {
        setContentView(R.layout.activity_main_task3);
    }



}