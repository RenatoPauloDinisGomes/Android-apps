package com.example.renato.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Renato on 10/08/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    List<String> Data;

    public RecyclerAdapter(List<String> data) {
        this.Data = data;
    }

    public void add(String a) {

        Data.add(a);
        notifyItemInserted(Data.size());
    }

    public void remove(String a) {
        int pos = Data.indexOf(a);
        if (pos != -1) {
            Data.remove(a);
            notifyItemRemoved(pos);
        }

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.ImageViewFace.setImageResource(R.drawable.kanface);
        holder.textView1.setText(Data.get(position));
        holder.textView2.setText("Id: " + position);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView1, textView2;
        private ImageView ImageViewFace;

        public RecyclerViewHolder(View itemView) {


            super(itemView);

            itemView.setOnClickListener(this);
            ImageViewFace = (ImageView) itemView.findViewById(R.id.img_card);
            textView2 = (TextView) itemView.findViewById(R.id.tv_id);
            textView1 = (TextView) itemView.findViewById(R.id.tv_nome);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
