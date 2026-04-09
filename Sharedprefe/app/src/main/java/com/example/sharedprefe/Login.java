package com.example.sharedprefe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText id,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        id = findViewById(R.id.id);
        pass = findViewById(R.id.pass);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(id.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
                  SharedPreferences pref = getSharedPreferences("loginn",MODE_PRIVATE);
                  SharedPreferences.Editor editor = pref.edit();
                  editor.putBoolean("flag",true);
                  editor.apply();
                  startActivity(new Intent(Login.this,Home.class));
                  finish();
              }else {
                  Toast.makeText(Login.this,"Invalid id or password",Toast.LENGTH_SHORT).show();
              }
            }
        });
    }
}