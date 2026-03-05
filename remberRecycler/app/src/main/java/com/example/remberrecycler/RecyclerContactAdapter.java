package com.example.remberrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
Context context;
    ViewHolder viewHolder;
    ArrayList<ContactModel> arrContant;
   RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContant){
       this.context=context;
       this.arrContant=arrContant;
   }
    public static class   ViewHolder extends RecyclerView.ViewHolder {

       TextView txtName,txtNumber;
       ImageView imgContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.ContactName);
            txtNumber= itemView.findViewById(R.id.txtNumber);
            imgContact=itemView.findViewById(R.id.imgContact);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
         viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.imgContact.setImageResource(arrContant.get(position).img);
     holder.txtName.setText(arrContant.get(position).name);
     holder.txtNumber.setText(arrContant.get(position).number);
    }

    @Override
    public int getItemCount() {
        return arrContant.size();
    }


}
