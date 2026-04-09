package com.example.notehub;

import static androidx.core.content.ContextCompat.startActivities;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {
    @NonNull
    Context context;

    ArrayList<list_Model> arrayList;
    int singleItem_selection_position=-1;
    RecyclerListAdapter(Context context,ArrayList<list_Model> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view =  LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
       ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListAdapter.ViewHolder holder, int position) {
      holder.title.setText(arrayList.get(position).title);

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent iSem = new Intent(context, semifinalist.class);
              int pos= holder.getAbsoluteAdapterPosition();
              iSem.putExtra("title",arrayList.get(pos).title);
              context.startActivity(iSem);
          }
      });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.lstxt);
        }
    }
}
