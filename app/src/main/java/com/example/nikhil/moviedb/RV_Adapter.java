package com.example.nikhil.moviedb;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by NIKHIL on 15-06-2018.
 */

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.myViewHolder> {

    Context mcontext;
   List<Result> mphotos;

    public RV_Adapter(Context mcontext,  List<Result> mphotos) {
        this.mcontext = mcontext;
        this.mphotos = mphotos;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Here we the context
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.card_view,null,false);

        return new myViewHolder(view);


    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {

        holder.tv.setText(mphotos.get(position).getTitle());
        String url = mphotos.get(position).getPosterPath();
        String final_url = "https://image.tmdb.org/t/p/h632/"+url;

        Glide.with(mcontext).load(final_url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

        holder.description.setText(mphotos.get(position).getOverview());



        //Photo listPhotos = mphotos.get(position);
        //holder.tv.setText(listPhotos.getName());

    }

    @Override
    public int getItemCount() {
        return mphotos.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv,description;
        ImageView imageView;


        public myViewHolder(View itemView) {
            super(itemView);


            tv = itemView.findViewById(R.id.ctv_id);
            imageView = itemView.findViewById(R.id.ctv_imageView);
            description = itemView.findViewById(R.id.ctv_desc);
        }
    }
}