package com.harshtech.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.RecyHolder> implements Filterable {
    List<String> data;
    List<String> backup;
    public RecyAdapter(List<String> data){
        this.data=data;
        this.backup=new ArrayList<>(data);
    }
    @NonNull
    @Override
    public RecyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_row,parent,false);
        return new RecyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    Filter filter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<String> filterdata=new ArrayList<String>();
            if(charSequence.toString().isEmpty())
                filterdata.addAll(backup);
            else
                for (String dat:backup)
                    if(dat.toString().toLowerCase().contains(charSequence.toString().toLowerCase()))
                        filterdata.add(dat);

            FilterResults filterResults=new FilterResults();
            filterResults.values=filterdata;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, @NonNull FilterResults filterResults) {
            data.clear();
            data.addAll( (ArrayList<String>) filterResults.values);

            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return filter;
    }

    class RecyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public RecyHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
