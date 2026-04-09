package com.example.notehub;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerSemAdapter extends RecyclerView.Adapter<RecyclerSemAdapter.ViewHolder> {

    Context context;
    ArrayList<list_Model> arrayList;
    String course;

    RecyclerSemAdapter(Context context, ArrayList<list_Model> arrayList,String course){
        this.context=context;
        this.arrayList=arrayList;
        this.course=course;
    }

    @NonNull
    @Override
    public RecyclerSemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSemAdapter.ViewHolder holder, int position) {
    holder.title.setText(arrayList.get(position).title);
    holder.itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int pos = holder.getAbsoluteAdapterPosition();
            Intent iSemList = new Intent(context, Sempdflist.class);
            iSemList.putExtra("title",arrayList.get(pos).title);
            iSemList.putExtra("key",course);
            context.startActivity(iSemList);

            
        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.lstxt);


        }
    }
}
