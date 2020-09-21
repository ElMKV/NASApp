package com.example.nasapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
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
    Dialog dialog;


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
                    int id = list.get(i).getId();
                    String name  = list.get(i).getName();
                    String sizeComet = list.get(i).getAbsolute_magnitude_h();
                    Boolean isPotentiallyHazardousAsteroid = list.get(i).getIs_potentially_hazardous_asteroid();
                    Boolean isSentryObject = list.get(i).getIs_sentry_object();

//                    Toast.makeText(view.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(context, CometActivityDescripion.class);
//                    intent.putExtra("id", id);
//                    intent.putExtra("name", name);
//                    intent.putExtra("sizeComet", sizeComet);
//                    intent.putExtra("isPotentiallyHazardousAsteroid", isPotentiallyHazardousAsteroid);
//                    intent.putExtra("isSentryObject", isSentryObject);


//                    context.startActivity(intent);




                }
            }

            dialog = new Dialog(context);
            // Установите заголовок
            dialog.setTitle("Заголовок диалога");
            // Передайте ссылку на разметку
            dialog.setContentView(R.layout.dialog_alert);
            // Найдите элемент TextView внутри вашей разметки
            // и установите ему соответствующий текст
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.show();


        }
    }

}
