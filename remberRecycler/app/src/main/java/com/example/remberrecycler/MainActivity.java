package com.example.remberrecycler;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContact = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerContactAdapter adapter;
    Button btnOpenDalouge;
    @SuppressLint("MissingInflatedId")
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
        recyclerView = findViewById(R.id.recyclerContact);

        btnOpenDalouge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add);
                EditText edtName = dialog.findViewById(R.id.ContactAddName);
                EditText edtNumber = dialog.findViewById(R.id.ContactAddNumber);
                Button btnAction = dialog.findViewById(R.id.ContactAddBtn);

                btnAction.setOnClickListener(new View.OnClickListener() {

                    String name="", number="";
                    @Override
                    public void onClick(View v) {

                        if ( edtName.getText().toString().equals("")) {
                             name = edtName.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Please enter name",Toast.LENGTH_LONG);
                        }
                        if (edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        }else {
                            Toast.makeText(MainActivity.this,"Please enter number",Toast.LENGTH_LONG);
                        }
                        arrContact.add(new ContactModel(name,number));
                        adapter.notifyItemInserted(arrContact.size()-1);
                        recyclerView.scrollToPosition(arrContact.size()-1);
                    }
                });
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContact.add(new ContactModel(R.drawable.bhaiya,"Raj Bhaiya ","7488678318"));
        arrContact.add(new ContactModel(R.drawable.dhiraj,"Dhiraj","29820912808"));
        arrContact.add(new ContactModel(R.drawable.fuwa,"Fuwa","2121123322312"));
        arrContact.add(new ContactModel(R.drawable.papa,"papa ","74886718"));
        arrContact.add(new ContactModel(R.drawable.riya,"riya","29820912808"));
        arrContact.add(new ContactModel(R.drawable.roshni,"roshni","2121123322312"));
        arrContact.add(new ContactModel(R.drawable.rahul,"Rahul ","7488678318"));
        arrContact.add(new ContactModel(R.drawable.rounak,"rounak","29820912808"));
        arrContact.add(new ContactModel(R.drawable.prem,"prem","2121123322312"));
        arrContact.add(new ContactModel(R.drawable.maa,"Maa ","7488678318"));
        arrContact.add(new ContactModel(R.drawable.tulshi,"tulshi","29820912808"));
        arrContact.add(new ContactModel(R.drawable.mithun,"mithun","2121123322312"));

         adapter =new RecyclerContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);
    }
}