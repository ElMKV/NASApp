package com.example.nasapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        return new ViewHolder(v);

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


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, star;


        public ViewHolder(View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.textViewNameComet);
            star=(TextView) itemView.findViewById(R.id.textViewStar);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {



            for(int i = 0; i<list.size(); i++){
                if(getLayoutPosition()==i){

                    Toast.makeText(view.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();

                    

                }
            }
        }
    }

}
