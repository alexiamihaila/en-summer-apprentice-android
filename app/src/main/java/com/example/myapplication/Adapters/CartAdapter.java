package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activities.DetailActivity;
import com.example.myapplication.Domains.CartDomain;
import com.example.myapplication.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

        ArrayList<CartDomain> events;
        DecimalFormat formatter;
        Context context;

        public CartAdapter(ArrayList<CartDomain> events){

            this.events = events;
            formatter = new DecimalFormat("####");

            }

        @NonNull
        @Override
        public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_viewholder,parent,false);
                context = parent.getContext();

                return new ViewHolder(inflate);
                }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

                holder.titleTxt.setText(events.get(position).getEventName());
                holder.descriptionTxt.setText(events.get(position).getDescription());
                holder.priceTxt.setText(String.valueOf(events.get(position).getPrice()));

                int drawableResourceId = holder.itemView.getResources().getIdentifier(events.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

                Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            Intent intent = new Intent(context, DetailActivity.class);
                            intent.putExtra("object", (CharSequence) events.get(position));
                            context.startActivity(intent);

                    }
                });
        }

        @Override
        public int getItemCount() {
                return events.size();
                }

        public class ViewHolder extends RecyclerView.ViewHolder{
            TextView titleTxt,priceTxt, descriptionTxt;
            ImageView pic;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                titleTxt = itemView.findViewById(R.id.titleTxt);
                priceTxt = itemView.findViewById(R.id.priceTxt);
                descriptionTxt = itemView.findViewById(R.id.descriptiontxt);
                pic = itemView.findViewById(R.id.pic);
            }
        }
}
