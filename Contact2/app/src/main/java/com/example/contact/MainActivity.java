package com.example.contact;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ContactModel> arrName  = new ArrayList<>();
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

        recyclerView = findViewById(R.id.RecyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrName.add(new ContactModel(R.drawable.bhaiya,"Raj bhaiya","8342746"));
        arrName.add(new ContactModel(R.drawable.dhiraj,"Dhiraj","347893"));
        arrName.add(new ContactModel(R.drawable.fuwa,"Fuwa","3245"));
        arrName.add(new ContactModel(R.drawable.maa,"Maa","3555556677"));
        arrName.add(new ContactModel(R.drawable.papa,"Papa","1234"));
        arrName.add(new ContactModel(R.drawable.mithun,"Mithun","23221334"));
        arrName.add(new ContactModel(R.drawable.piyush,"Piyush","4544333455"));
        arrName.add(new ContactModel(R.drawable.prem,"Prem","1234567"));
        arrName.add(new ContactModel(R.drawable.rahul,"Rahul","1111111111"));
        arrName.add(new ContactModel(R.drawable.riya,"Riya","11222222222"));
        arrName.add(new ContactModel(R.drawable.roshni,"Roshni","3724687"));
        arrName.add(new ContactModel(R.drawable.rounak,"Rounak","63636565632"));
        arrName.add(new ContactModel(R.drawable.nitish,"Nitish","354634"));
        arrName.add(new ContactModel(R.drawable.tulshi,"Tulshi","4334535"));

        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrName);
        recyclerView.setAdapter(adapter);


    }
}