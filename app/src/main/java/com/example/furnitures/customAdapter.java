package com.example.furnitures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class customAdapter extends RecyclerView.Adapter<customAdapter.MyViewHolder>{

    public ArrayList<DataModel> dataset;
    private Context mcontext;

    public customAdapter(ArrayList<DataModel> dataset, Context mcontext) {

        this.dataset = dataset;
        this.mcontext = mcontext;
    }


    @NonNull
    @Override
    public customAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,parent,false);

        MyViewHolder viewHolder=new MyViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull customAdapter.MyViewHolder holder, int position) {
        TextView textviewname=holder.textViewName;
        TextView textviewversion=holder.textViewVersion;
        ImageView imageView=holder.imageViewIcon;
        textviewname.setText(dataset.get(position).getName());
        textviewversion.setText(dataset.get(position).getVersion());
        Glide.with(mcontext).load(dataset.get(position).getImage()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(imageView);






    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.textViewName);
            this.textViewVersion = itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = itemView.findViewById(R.id.imageView);
        }



        @Override
        public void onClick(View v) {

                Toast.makeText(v.getContext(), "Clicked on", Toast.LENGTH_SHORT).show();


        }
    }
}
