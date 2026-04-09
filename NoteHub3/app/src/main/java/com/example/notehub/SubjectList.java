package com.example.notehub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubjectList extends AppCompatActivity {

    RecyclerView  recyclerView;
    ArrayList<list_Model> arrayList = new ArrayList<>();
    TextView textView1,textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subject_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView1 =findViewById(R.id.textSub1);
        textView2 =findViewById(R.id.textSub2);
        textView3 =findViewById(R.id.textSub3);

        String name = getIntent().getStringExtra("name");
        String course = getIntent().getStringExtra("key");
        String subject = getIntent().getStringExtra("title");
        textView1.setText(" "+ course +" ");
        textView2.setText(""+name +" ");
        textView3.setText(""+subject+" ");

        try {
            recyclerView = findViewById(R.id.recyclerViewSubject);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Initialize the arrayList before adding items to it to avoid NullPointerException
//            arrayList = new ArrayList<>();
            arrayList.add(new list_Model("Notes"));
            arrayList.add(new list_Model("PYQ"));

            RecyclerSubPdfListAdapter adapter= new RecyclerSubPdfListAdapter(this,arrayList,name,course,subject);
            recyclerView.setAdapter(adapter);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}