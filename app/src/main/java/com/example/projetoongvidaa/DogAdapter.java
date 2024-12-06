package com.example.projetoongvidaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    private List<Dog> dogList;

    public DogAdapter(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public DogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new DogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DogViewHolder holder, int position) {
        Dog dog = dogList.get(position);

        // Definir o nome e a descrição
        holder.dogName.setText(dog.getNome());
        holder.dogDescription.setText(dog.getDescricao());

        // Carregar a imagem
        if (dog.getImageUrl() != null && !dog.getImageUrl().isEmpty()) {
            // Carregar a imagem do drawable com base no nome armazenado
            Context context = holder.itemView.getContext();
            int resourceId = context.getResources().getIdentifier(dog.getImageUrl(), "drawable", context.getPackageName());

            if (resourceId != 0) {
                holder.dogImageView.setImageResource(resourceId);  // Definir a imagem
            } else {
                holder.dogImageView.setImageResource(R.drawable.cachorro);  // Se não encontrado, use uma imagem padrão
            }
        } else {
            holder.dogImageView.setImageResource(R.drawable.cachorro);  // Carregar uma imagem padrão caso a URL esteja vazia ou nula
        }
    }

    @Override
    public int getItemCount() {
        return dogList.size();
    }

    public static class DogViewHolder extends RecyclerView.ViewHolder {
        public TextView dogName;
        public TextView dogDescription;
        public ImageView dogImageView;

        public DogViewHolder(View itemView) {
            super(itemView);

            dogName = itemView.findViewById(R.id.dogName);
            dogDescription = itemView.findViewById(R.id.dogDescription);
            dogImageView = itemView.findViewById(R.id.dogImageView);  // Inicializando a referência à ImageView
        }
    }
}

