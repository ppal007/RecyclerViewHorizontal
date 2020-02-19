package com.ppal007.recyclerviewhorizontal.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ppal007.recyclerviewhorizontal.GalleryActivity;
import com.ppal007.recyclerviewhorizontal.R;
import com.ppal007.recyclerviewhorizontal.model.Model1;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Model1> model1s;
    private Context context;

    //    constractor
    public RecyclerViewAdapter(ArrayList<Model1> model1s, Context context) {
        this.model1s = model1s;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_sample,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        set logo to image view
        holder.imageView.setImageResource(model1s.get(position).getLogo());
        holder.textView.setText(model1s.get(position).getTeam());

//        set click listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                get image path
                int path = model1s.get(position).getLogo();


                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("ex_logo", path);
                intent.putExtra("ex_name", model1s.get(position).getTeam());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return model1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //        initialize variable
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            assign variable
            imageView = itemView.findViewById(R.id.imageview_recycler_sample);
            textView = itemView.findViewById(R.id.tv_recycler_sample);
        }
    }
}
