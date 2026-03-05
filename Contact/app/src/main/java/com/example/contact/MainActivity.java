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
    ArrayList<ContactModel> arrContact;
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
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       arrContact.add(new ContactModel(R.drawable.bhaiya,"Raj Bhaiya","1111111111111"));
        arrContact.add(new ContactModel(R.drawable.dhiraj,"Dhiraj","22222222"));
        arrContact.add(new ContactModel(R.drawable.fuwa,"Fuwa","33333333333"));
        arrContact.add(new ContactModel(R.drawable.maa,"Maa","44444444"));
        arrContact.add(new ContactModel(R.drawable.papa,"Papa","555555666666666"));
        arrContact.add(new ContactModel(R.drawable.mithun,"Mithun","66666666666"));
        arrContact.add(new ContactModel(R.drawable.piyush,"piyush","777777777"));
        arrContact.add(new ContactModel(R.drawable.prem,"prem","88888888888"));
        arrContact.add(new ContactModel(R.drawable.rahul,"rahul","99999999999"));
        arrContact.add(new ContactModel(R.drawable.roshni,"roshani","111111122222222"));
        arrContact.add(new ContactModel(R.drawable.rounak,"rounak","11111111111222222222233333"));
        arrContact.add(new ContactModel(R.drawable.tulshi,"tulshi","111222222222333333444"));
        arrContact.add(new ContactModel(R.drawable.riya,"riya","1111112222223334455"));
        arrContact.add(new ContactModel(R.drawable.nitish,"nitish","111111222222333445566"));



        RecyclerContactAdapter adapter = new RecyclerContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);



    }
}