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
import java.util.zip.Inflater;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
 Context context;
 ArrayList<ContactModel> arrContact;
public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContant){
    this.arrContact=arrContant;
    this.context=context;
}
    @NonNull
    @Override
    public RecyclerContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
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

    public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView name,number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgContant);
            name= itemView.findViewById(R.id.txtName);
            number=itemView.findViewById(R.id.txtNumber);

        }
    }
}
