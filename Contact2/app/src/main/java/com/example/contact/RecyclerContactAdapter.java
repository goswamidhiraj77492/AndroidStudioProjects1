package com.example.contact;

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

    ArrayList<ContactModel> arrContact;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact){
        this.context= context;
        this.arrContact= arrContact;
    }

    @NonNull
    @Override
    public RecyclerContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerContactAdapter.ViewHolder holder, int position) {
     holder.img.setImageResource(arrContact.get(position).img);
     holder.name.setText(arrContact.get(position).name);
     holder.number.setText(arrContact.get(position).number);
    }

    @Override
    public int getItemCount() {

        return arrContact.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name , number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgContact);
            name = itemView.findViewById(R.id.contactName);
            number = itemView.findViewById(R.id.contactNumber);
        }
    }
}
