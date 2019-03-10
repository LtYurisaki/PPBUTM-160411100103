package com.example.PraktikumPPB_D2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Task1Activity extends AppCompatActivity {

    EditText name;
    Button btnSend;
    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        name = findViewById(R.id.editName);
        btnSend = findViewById(R.id.btnHallo);
        tv_name = findViewById(R.id.tv_name);

    }

    public void halloAct(View view) {
        if (name.getText().toString().equals("")){
            nama.setError("It must be filled");
        }else {
            String n = name.getText().toString();
            tv_name.setText(String.format("Hello %s ",n));
        }
    }
}
