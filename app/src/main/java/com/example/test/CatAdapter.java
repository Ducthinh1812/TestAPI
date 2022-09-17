package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.modelHolder> {

    Context context;
    ArrayList<Cat> ArrayLists;
    ArrayList<DetailCat> detailscatas;
    public CatAdapter(Context context, ArrayList<Cat> ArrayLists) {
        this.context = context;
        this.ArrayLists = ArrayLists;
    }

    @NonNull
    @Override
    public CatAdapter.modelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent, false);
        return new CatAdapter.modelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatAdapter.modelHolder holder, @SuppressLint("RecyclerView") int position) {
        Cat timKiem = ArrayLists.get(position);

//        holder.tvname.setText(timKiem.getId());
        Picasso.get().load(timKiem.getUrl())
                .into(holder.imgSP);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MainActivity2.class);
                intent.putExtra("id",timKiem.getId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return ArrayLists.size();

    }

    public class modelHolder extends RecyclerView.ViewHolder {
        ImageView imgSP;
//        TextView tvname;
        LinearLayout linearLayout;
        public modelHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout= itemView.findViewById(R.id.lead);
            imgSP = (ImageView) itemView.findViewById(R.id.imageView2);
//            tvname = (TextView) itemView.findViewById(R.id.textView);

        }
    }

}
