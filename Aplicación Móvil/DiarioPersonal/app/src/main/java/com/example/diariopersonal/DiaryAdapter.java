package com.example.diariopersonal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiarioViewHolder> {
    private List<Diary> diarios;
    private OnItemClickListener onItemClickListener;

    public static class DiarioViewHolder extends RecyclerView.ViewHolder {
        public TextView txtKey, txtFecha, txtHora, txtUbicacion, txtDescripcion;
        public ImageView imagen;
        public CardView card_diary;

        public DiarioViewHolder(View itemView) {
            super(itemView);
            txtKey = itemView.findViewById(R.id.TxtKey);
            txtFecha = itemView.findViewById(R.id.TxtFecha);
            txtHora = itemView.findViewById(R.id.TxtHora);
            txtUbicacion = itemView.findViewById(R.id.TxtUbicacion);
            txtDescripcion = itemView.findViewById(R.id.TxtDescripcion);
            imagen = itemView.findViewById(R.id.Imagen);
            card_diary = itemView.findViewById(R.id.Card_Diary);
        }

        public void Click(final Diary saveRecipe, final OnItemClickListener click){
            card_diary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (click != null) {
                        click.onItemClick(card_diary, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(DiaryAdapter.OnItemClickListener click){
        this.onItemClickListener = click;
    }

    public DiaryAdapter(List<Diary> diarioList) {
        this.diarios = diarioList;
    }

    @NonNull
    @Override
    public DiaryAdapter.DiarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_diary, parent, false);
        return new DiaryAdapter.DiarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryAdapter.DiarioViewHolder holder, int position) {
        Diary diario = diarios.get(position);
        holder.txtKey.setText(diario.getKey());
        holder.txtFecha.setText(diario.getFecha());
        holder.txtHora.setText("Hora: " + diario.getHora());
        holder.txtUbicacion.setText("Ubicación: " + diario.getUbicacion());
        holder.txtDescripcion.setText(diario.getDescripcion());
        Glide.with(holder.itemView.getContext())
                .load(diario.getImagen())
                .into(holder.imagen);
        holder.Click(diario, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return diarios.size();
    }

    public Diary getPosicionDiario(int position) {
        return diarios.get(position);
    }
}
