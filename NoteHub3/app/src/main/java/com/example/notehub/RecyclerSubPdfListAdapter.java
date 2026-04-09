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

public class RecyclerSubPdfListAdapter extends RecyclerView.Adapter<RecyclerSubPdfListAdapter.ViewHolder> {
    @NonNull
    Context context;
    String name,course,subject;
    ArrayList<list_Model> arrayList;

    RecyclerSubPdfListAdapter(Context context, ArrayList<list_Model> arrayList  , String name, String course, String subject){
       this.context=context;
       this.arrayList=arrayList;
       this.name=name;
       this.course=course;
       this.subject=subject;
    }
    @Override
    public RecyclerSubPdfListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSubPdfListAdapter.ViewHolder holder, int position) {
     holder.title.setText(arrayList.get(position).title);
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         int pos = holder.getAbsoluteAdapterPosition();
         @Override
         public void onClick(View v) {
             Intent iSubpdfList = new Intent(context, SubjectNotesPyqPdfList.class);
             iSubpdfList.putExtra("title",arrayList.get(pos).title);
             iSubpdfList.putExtra("course",course);
             iSubpdfList.putExtra("name",name);
             iSubpdfList.putExtra("subject",subject);

             context.startActivity(iSubpdfList);
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
