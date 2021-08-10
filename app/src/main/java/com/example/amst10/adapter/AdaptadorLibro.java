package com.example.amst10.adapter;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amst10.Libro;
import com.example.amst10.R;
import com.example.amst10.model.ItemList;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorLibro extends RecyclerView.Adapter<AdaptadorLibro.RecyclerHolder> {
    private List<ItemList> items;

    public AdaptadorLibro(List<ItemList> items) {
        this.items=items;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlistview,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerHolder holder, int position) {
        ItemList item=items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.titulo.setText(item.getTitulo());
        holder.autor.setText(item.getAutor());
        holder.editorial.setText(item.getEditorial());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private TextView titulo;
        private TextView autor;
        private TextView editorial;

        public RecyclerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgItem=itemView.findViewById(R.id.imgItem);
            titulo=itemView.findViewById(R.id.titulo);
            autor=itemView.findViewById(R.id.autor);
            editorial=itemView.findViewById(R.id.editorial);
        }
    }
}
