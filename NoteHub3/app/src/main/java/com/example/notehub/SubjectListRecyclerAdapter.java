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

public class SubjectListRecyclerAdapter extends RecyclerView.Adapter<SubjectListRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<list_Model> arrayList;
    String name,course,subject,type;
    SubjectListRecyclerAdapter(Context context, ArrayList<list_Model> arrayList, String course, String name, String subject, String type){
        this.context=context;
        this.arrayList =arrayList;
        this.course=course;
        this.name=name;
        this.subject=subject;
        this.type=type;
    }


    @NonNull
    @Override
    public SubjectListRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectListRecyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText(arrayList.get(position).title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            int pos = holder.getAbsoluteAdapterPosition();
            @Override
            public void onClick(View v) {
                Intent iSubList = new Intent(context, MainPdfViewActivity.class);
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
            title=itemView.findViewById(R.id.lstxt);
        }
    }
}
