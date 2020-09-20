package com.example.nasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CometAdapter extends RecyclerView.Adapter<CometAdapter.ViewHolder> {

    Context context;
    List<NearEarthObject> list;
    public CometAdapter(Context context,List<NearEarthObject> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public CometAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CometAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.star.append( " " +  list.get(position).getAbsolute_magnitude_h());

    }

    @Override
    public int getItemCount() {
        return list.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, star;


        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.textViewNameComet);
            star=(TextView) itemView.findViewById(R.id.textViewStar);
        }
    }
}
