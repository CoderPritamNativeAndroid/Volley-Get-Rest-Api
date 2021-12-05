package com.pritampachal.volleyhttplibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapterClass extends RecyclerView.Adapter<RecyclerViewAdapterClass.ViewHolderClass> {
    ArrayList<RecyclerViewModelClass> arrayList;

    public RecyclerViewAdapterClass(ArrayList<RecyclerViewModelClass> arrayList) {
        this.arrayList = arrayList;
    }

    public static class ViewHolderClass extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewAlbum,textViewTitle;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textViewAlbum=itemView.findViewById(R.id.textViewAlbumID);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapterClass.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderClass(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_class_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterClass.ViewHolderClass holder, int position) {
        RecyclerViewModelClass recyclerViewModelClass=arrayList.get(position);
        Picasso.get().load(""+recyclerViewModelClass.getImage()).into(holder.imageView);
        holder.textViewAlbum.setText("AlbumID == "+recyclerViewModelClass.getAlbumID());
        holder.textViewTitle.setText("Title == "+recyclerViewModelClass.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "ID == "+recyclerViewModelClass.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
