package com.example.PraktikumPPB_D2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTask1, btnTask2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTask1 = findViewById(R.id.btnTask1);
        btnTask2 = findViewById(R.id.btnTask2);
    }

    public void task1(View view) {
        Intent intent = new Intent(MainActivity.this, Task1Activity.class);
        startActivity(intent);
    }

    public void task2(View view) {
    }
}
