package com.example.notehub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerSublistAdapter extends RecyclerView.Adapter<RecyclerSublistAdapter.ViewHolder> {
    @NonNull
    Context  context;
    String name,course;
    ArrayList<list_Model> arrayList ;
    RecyclerSublistAdapter(Context  context,ArrayList<list_Model> arrayList ,String name,String course){
       this.context=context;
       this.arrayList=arrayList;
       this.name=name;
       this.course=course;
    }
    @Override
    public RecyclerSublistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSublistAdapter.ViewHolder holder, int position) {
     holder.title.setText(arrayList.get(position).title);
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         int pos = holder.getAbsoluteAdapterPosition();
         @Override
         public void onClick(View v) {
             Intent iSubList = new Intent(context, SubjectList.class);
             iSubList.putExtra("title",arrayList.get(pos).title);
             iSubList.putExtra("name",name);
             iSubList.putExtra("key",course);
             context.startActivity(iSubList);
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
