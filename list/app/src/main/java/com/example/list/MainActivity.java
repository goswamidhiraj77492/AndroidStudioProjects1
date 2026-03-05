package com.example.list;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrName = new ArrayList<>();
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
        listView = findViewById(R.id.listView);

        arrName.add("Bittu");
        arrName.add("priya");
        arrName.add("Dhiraj");
        arrName.add("baby");
        arrName.add("raj");
        arrName.add("rahul");
        arrName.add("ram");
        arrName.add("shiv");
        arrName.add("krishna");
        arrName.add("om");
        arrName.add("deeppa");
        arrName.add("usha");
        arrName.add("rani");
        arrName.add("shivani");
        arrName.add("chandni");
        arrName.add("roshani");
        arrName.add("riya");
        arrName.add("gautam");
        arrName.add("aman");
        arrName.add("anil");
        arrName.add("kaushal");
        arrName.add("prianshu");
        arrName.add("rounak");
        arrName.add("nitish");
        arrName.add("abhishek");
        arrName.add("mithun");
        arrName.add("jai");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(MainActivity.this, "welcome bittu", Toast.LENGTH_SHORT).show();
                }else if(position==1){
                    Toast.makeText(MainActivity.this, "welcome priya", Toast.LENGTH_SHORT).show();
                }else if(position==2){
                Toast.makeText(MainActivity.this, "welcome Dhiraj", Toast.LENGTH_SHORT).show();
            }
            }

    }
}