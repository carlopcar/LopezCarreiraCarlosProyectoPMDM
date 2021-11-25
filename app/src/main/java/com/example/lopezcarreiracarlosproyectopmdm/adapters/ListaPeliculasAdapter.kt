package com.example.lopezcarreiracarlosproyectopmdm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.activities.DetallePeliculaActivity
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.squareup.picasso.Picasso

class ListaPeliculasAdapter (private val peliculas: List<Pelicula>, val context: Context) : RecyclerView.Adapter<ListaPeliculasAdapter.PeliculasViewHolder>() {

    //Adapter: tres métodos y clase ViewHolder
    class PeliculasViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvDirector: TextView = itemView.findViewById(R.id.tvDirector)
        val tvGenero: TextView = itemView.findViewById(R.id.tvGenero)
        val tvNota: TextView = itemView.findViewById(R.id.tvNota)
        val ivFoto: ImageView = itemView.findViewById(R.id.ivFoto)
        val cvLista: CardView = itemView.findViewById(R.id.cvLista)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculasViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)

        return PeliculasViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: PeliculasViewHolder, position: Int) {
        val pelicula = peliculas[position]

        holder.tvTitulo.text = pelicula.titulo
        holder.tvDirector.text = pelicula.director
        holder.tvGenero.text = pelicula.genero
        holder.tvNota.text = pelicula.nota

        Picasso.get().load(pelicula.url).into(holder.ivFoto)


        holder.cvLista.setOnClickListener{
            val intent = Intent(context, DetallePeliculaActivity::class.java)
            intent.putExtra("pelicula",pelicula)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

}