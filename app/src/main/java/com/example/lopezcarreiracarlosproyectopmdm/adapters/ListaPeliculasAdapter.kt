package com.example.lopezcarreiracarlosproyectopmdm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.squareup.picasso.Picasso

class ListaPeliculasAdapter (val peliculas: List<Pelicula>) : RecyclerView.Adapter<ListaPeliculasAdapter.PeliculasViewHolder>() {

    //Adapter: tres métodos y clase ViewHolder
    class PeliculasViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvTitulo = itemView.findViewById<TextView>(R.id.tvTitulo)
        val tvAutor = itemView.findViewById<TextView>(R.id.tvAutor)
        val tvGenero = itemView.findViewById<TextView>(R.id.tvGenero)
        val tvNota = itemView.findViewById<TextView>(R.id.tvNota)
        val ivFoto = itemView.findViewById<ImageView>(R.id.ivFoto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)

        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas.get(position)

        holder.tvTitulo.setText(pelicula.titulo)
        holder.tvAutor.setText(pelicula.autor)
        holder.tvGenero.setText(pelicula.genero)
        holder.tvNota.setText(pelicula.nota)

        Picasso.get().load(pelicula.url).into(holder.ivFoto)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }
}