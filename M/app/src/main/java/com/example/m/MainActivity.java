package com.example.m;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtw, edthf, edthin;
    TextView txtv;
    Button btncal;

    LinearLayout main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtw = findViewById(R.id.edtwt);
        edthf = findViewById(R.id.edtHFT);
        edthin = findViewById(R.id.edtHIn);
        txtv = findViewById(R.id.txtv);
        btncal = findViewById(R.id.btncal);
        main = findViewById(R.id.main);


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  wt = Integer.parseInt( edtw.getText().toString());
                int hf = Integer.parseInt(edthf.getText().toString());
                int hi = Integer.parseInt(edthin.getText().toString());

                int totalIn = hf * 12 + hi;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;

                double bmi = wt/(totalM *totalM);

                if (bmi>25){
                    txtv.setText(R.string.over);
                    int o = ContextCompat.getColor(MainActivity.this,R.color.overw);
                    main.setBackgroundColor(o);
                }else if (bmi<18) {
                    txtv.setText(R.string.under);
                    int u = ContextCompat.getColor(MainActivity.this,R.color.underw);
                    main.setBackgroundColor(u);
                }
                else {
                    txtv.setText(R.string.healthy);
                    int h = ContextCompat.getColor(MainActivity.this,R.color.heat);
                    main.setBackgroundColor(h);
                }
                }
        });





    }
}