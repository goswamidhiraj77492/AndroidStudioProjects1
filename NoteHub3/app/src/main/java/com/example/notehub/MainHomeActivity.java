package com.example.notehub;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainHomeActivity extends AppCompatActivity {

RecyclerView recyclerView;
Toolbar toolbar;
ArrayList<list_Model>  arrList = new ArrayList<list_Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_home);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(0); // white icons
        }

        toolbar =findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrList.add(new list_Model("BCA"));
        arrList.add(new list_Model("BBA"));
        arrList.add(new list_Model("B.com"));
        arrList.add(new list_Model("Bio.Tech"));
        arrList.add(new list_Model("Economics"));
        arrList.add(new list_Model("English"));
        arrList.add(new list_Model("Math"));
        arrList.add(new list_Model("Physics"));
        arrList.add(new list_Model("Chemistry"));
        arrList.add(new list_Model("History"));
        arrList.add(new list_Model("Geography"));

        RecyclerListAdapter adapter = new RecyclerListAdapter((this),arrList);
        recyclerView.setAdapter(adapter);





    }
}