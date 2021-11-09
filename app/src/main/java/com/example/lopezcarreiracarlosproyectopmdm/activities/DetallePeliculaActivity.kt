package com.example.lopezcarreiracarlosproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityDetallePeliculaBinding
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityLoginBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.squareup.picasso.Picasso

class DetallePeliculaActivity : AppCompatActivity() {

    companion object{
        lateinit var pelicula: Pelicula
    }

    private lateinit var binding: ActivityDetallePeliculaBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula
        binding.tvDTitulo.text = pelicula.titulo
        binding.tvDDirector.text="Director: " +pelicula.director
        binding.tvDGenero.text="Género: " +pelicula.genero
        binding.tvDAno.text="Año del estreno: " +pelicula.ano
        binding.tvDDuracion.text="Duración: " + pelicula.duracion
        binding.tvDMusica.text="Música: " + pelicula.musica
        binding.tvDFotografia.text="Fotografía: "+pelicula.fotografia
        binding.tvDDescripcion.text="Sinopsis\n"+pelicula.descripcion

        Picasso.get().load(pelicula.url).into(binding.ivPelicula)
    }
}