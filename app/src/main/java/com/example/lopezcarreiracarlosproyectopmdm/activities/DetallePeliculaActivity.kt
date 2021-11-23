package com.example.lopezcarreiracarlosproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lopezcarreiracarlosproyectopmdm.R
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
        setTitle(pelicula.titulo)

        binding.tvDDirector.text="Director: " +pelicula.director
        binding.tvDGenero.text="Género: " +pelicula.genero
        binding.tvDAno.text="Año del estreno: " +pelicula.ano
        binding.tvDDuracion.text="Duración: " + pelicula.duracion
        binding.tvDMusica.text="Música: " + pelicula.musica
        binding.tvDFotografia.text="Fotografía: "+pelicula.fotografia
        binding.tvDPais.text="País: "+pelicula.pais
        binding.tvDDescripcion.text="Sinopsis: \n\n"+pelicula.descripcion


        Picasso.get().load(pelicula.url).into(binding.ivPelicula)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_peliculas,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.accion_editar -> {
                return false
            }

            R.id.accion_borrar -> {
                return false
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}