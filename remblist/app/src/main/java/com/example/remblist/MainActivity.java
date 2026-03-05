package com.example.remblist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    Spinner spinner ;
    ArrayList<String> arrname = new ArrayList<>();


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

        spinner= findViewById(R.id.spinner);

        arrname.add("dhiraj");
        arrname.add("raj");
        arrname.add("dhiraj1");
        arrname.add("raj1");
        arrname.add("dhiraj2");
        arrname.add("raj2");
        arrname.add("dhiraj3");
        arrname.add("raj3");
        arrname.add("dhiraj4");
        arrname.add("raj4");

        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,arrname);
        spinner.setAdapter(adapter);


    }
}