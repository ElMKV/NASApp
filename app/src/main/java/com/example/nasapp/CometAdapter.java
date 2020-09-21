package com.example.nasapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CometAdapter extends RecyclerView.Adapter<CometAdapter.ViewHolder> {


    Context context;
    List<NearEarthObject> list;

    public CometAdapter(Context context, List<NearEarthObject> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public CometAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        ViewHolder holder = new ViewHolder(v);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull CometAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.star.append(" " + list.get(position).getAbsolute_magnitude_h());

    }

    @Override
    public int getItemCount() {
        return list.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, star;


        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textViewNameComet);
            star = (TextView) itemView.findViewById(R.id.textViewStar);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            LayoutInflater li = LayoutInflater.from(context);
            View promptsView = li.inflate(R.layout.dialog_alert, null);
            dialog.setView(promptsView);
            final TextView textViewId = (TextView) promptsView.findViewById(R.id.textViewId);
            final TextView textViewName = (TextView) promptsView.findViewById(R.id.textViewName);
            final TextView textViewSizeComet = (TextView) promptsView.findViewById(R.id.textViewSizeComet);
            final TextView textViewIsPotentiallyHazardousAsteroid = (TextView) promptsView.findViewById(R.id.textViewisPotentiallyHazardousAsteroid);
            final TextView textViewIsSentryObject = (TextView) promptsView.findViewById(R.id.textViewIsSentryObject);



            for (int i = 0; i < list.size(); i++) {
                if (getLayoutPosition() == i) {
                    String id = String.valueOf(list.get(i).getId());
                    String name = list.get(i).getName();
                    String sizeComet = list.get(i).getAbsolute_magnitude_h();
                    Boolean isPotentiallyHazardousAsteroid = list.get(i).getIs_potentially_hazardous_asteroid();
                    Boolean isSentryObject = list.get(i).getIs_sentry_object();

                    Log.d("comeize", sizeComet);

                    textViewId.setText("Номер: " + id );
                    textViewName.setText("Имя: " + name);
                    textViewSizeComet.setText("Звездный размер : " + sizeComet);

                    if (isPotentiallyHazardousAsteroid)
                    {
                        textViewIsPotentiallyHazardousAsteroid.setText(" Этот объект опасен");
                    }
                    else {
                        textViewIsPotentiallyHazardousAsteroid.setText("Этот объект не опасен");
                    }
                    if (isSentryObject)
                    {
                        textViewIsSentryObject.setText("Этот объект наблюдаем");
                    }
                    else {
                        textViewIsSentryObject.setText("Этот объект не наблюдаем");
                    }
                }
            }
            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
    }


}
