package com.example.notehub;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class semifinalist extends AppCompatActivity {

    RecyclerView recyclerView2;
    TextView textView;

    ArrayList<list_Model> arrList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_semlistpage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        toolbar = findViewById(R.id.semlisttoolbar);
//        setSupportActionBar(toolbar);
//
//        getActionBar().setDisplayHomeAsUpEnabled(true);
textView = findViewById(R.id.courtxt);
 String course = getIntent().getStringExtra("title");
textView.setText(course);

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        if("BCA".equals(course)||"Bio.Tech".equals(course)) {
            arrList.add(new list_Model("Sem 1"));
            arrList.add(new list_Model("Sem 2"));
            arrList.add(new list_Model("Sem 3"));
            arrList.add(new list_Model("Sem 4"));
            arrList.add(new list_Model("Sem 5"));
            arrList.add(new list_Model("Sem 6"));
        }else{
            arrList.add(new list_Model("Sem 1"));
            arrList.add(new list_Model("Sem 2"));
            arrList.add(new list_Model("Sem 3"));
            arrList.add(new list_Model("Sem 4"));
            arrList.add(new list_Model("Sem 5"));
            arrList.add(new list_Model("Sem 6"));
            arrList.add(new list_Model("Sem 7"));
            arrList.add(new list_Model("Sem 8"));

        }

        RecyclerSemAdapter adapter = new RecyclerSemAdapter((this),arrList,course);
        recyclerView2.setAdapter(adapter);

    }
}