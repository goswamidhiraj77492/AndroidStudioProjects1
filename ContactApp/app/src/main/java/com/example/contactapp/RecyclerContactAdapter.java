package com.example.contactapp;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.ArrayList;

public class RecyclerContactAdapter  extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>{
    ArrayList<ContactModel> arrname;
    Context context;
    ViewHolder viewHolder;
    RecyclerContactAdapter(Context context,ArrayList<ContactModel> arrname) {
        this.context = context;
        this.arrname = arrname;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
  holder.img.setImageResource(arrname.get(position).img);
  holder.name.setText(arrname.get(position).name);
  holder.number.setText(arrname.get(position).number);

  holder.CSLL.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Dialog dialog = new Dialog(context);
          dialog.setContentView(R.layout.contact_save);

          EditText UCName = dialog.findViewById(R.id.CSName);
          EditText UCNumber = dialog.findViewById(R.id.CSNumber);
          Button UCUpdate = dialog.findViewById(R.id.CSAdd);
          TextView txtTitle = dialog.findViewById(R.id.title);

          txtTitle.setText("Update Contact");
          UCUpdate.setText("Update");

          UCUpdate.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  String name="" , number="";
                  if (UCName.getText().toString().isEmpty()){
                      Toast.makeText(context, "Enter Name", Toast.LENGTH_SHORT).show();
                  }else {
                      name = UCName.getText().toString();
                  }
                  if (UCNumber.getText().toString().isEmpty()){
                      Toast.makeText(context, "Enter Number", Toast.LENGTH_SHORT).show();
                  }else {
                      number = UCNumber.getText().toString();
                  }

                  arrname.set(position,new ContactModel(name,number));
                  notifyItemChanged(position);
                  dialog.dismiss();

              }
          });

dialog.dismiss();
      }

  });

    }

    @Override
    public int getItemCount() {
        return arrname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        LinearLayout CSLL;
         TextView name , number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img=itemView.findViewById(R.id.contactImg);
            this.name = itemView.findViewById(R.id.contactName);
            this.number=itemView.findViewById(R.id.contactNumber);
            this.CSLL= itemView.findViewById(R.id.CSLl);
        }
    }
}


