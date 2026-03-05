package com.example.grid;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
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
        b1= findViewById(R.id.btn1);
        b2= findViewById(R.id.btn2);
        b3= findViewById(R.id.btn3);
        b4= findViewById(R.id.btn4);
        b5= findViewById(R.id.btn5);
        b6= findViewById(R.id.btn6);
        b7= findViewById(R.id.btn7);
        b8= findViewById(R.id.btn8);
        b9= findViewById(R.id.btn9);


    }
}