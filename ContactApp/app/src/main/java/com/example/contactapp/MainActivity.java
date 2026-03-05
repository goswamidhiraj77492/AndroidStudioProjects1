package com.example.contactapp;


import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerContactAdapter adapter;
   
    FloatingActionButton addBtn;
    LinearLayout linearLayout;
    ArrayList<ContactModel> arrname = new ArrayList<>();

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
        addBtn = findViewById(R.id.addBtn);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        addBtn.setOnClickListener(v -> {

            Dialog dialog =new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.contact_save);

            EditText csName = dialog.findViewById(R.id.CSName);
            EditText csNumber = dialog.findViewById(R.id.CSNumber);
            Button csAdd = dialog.findViewById(R.id.CSAdd);

            csAdd.setOnClickListener(v1 -> {
                String name="" , number="";
                if (csName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }else {
                    name = csName.getText().toString();
                }
                if (csNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Number", Toast.LENGTH_SHORT).show();
                }else {
                    number = csNumber.getText().toString();
                }

                arrname.add(new ContactModel(name,number));
                adapter.notifyItemChanged(arrname.size()-1);
                recyclerView.scrollToPosition(arrname.size()-1);
                dialog.dismiss();
            });

            dialog.show();
        });

        arrname.add(new ContactModel(R.drawable.bhaiya,"Raj Bhaiya","7488678318"));
        arrname.add(new ContactModel(R.drawable.dhiraj,"Dhiraj","16678617"));
        arrname.add(new ContactModel(R.drawable.fuwa,"Fuwa","637617"));
        arrname.add(new ContactModel(R.drawable.maa,"Maa","7228222"));
        arrname.add(new ContactModel(R.drawable.papa,"Papa","27778613876"));
        arrname.add(new ContactModel(R.drawable.mithun,"Mithun","31y613"));
        arrname.add(new ContactModel(R.drawable.nitish,"Nitish","262768"));
        arrname.add(new ContactModel(R.drawable.piyush,"Piyush","27627687"));
        arrname.add(new ContactModel(R.drawable.prem,"Prem","6545332"));
        arrname.add(new ContactModel(R.drawable.riya,"Riya","3232342"));
        arrname.add(new ContactModel(R.drawable.rahul,"Rahul","43221321"));
        arrname.add(new ContactModel(R.drawable.roshni,"Roshani","23246722"));
        arrname.add(new ContactModel(R.drawable.rounak,"Rounak","76224515"));
        arrname.add(new ContactModel(R.drawable.tulshi,"Tulshi","46783678625"));

        adapter = new RecyclerContactAdapter(this,arrname);
        recyclerView.setAdapter(adapter);





    }
}
