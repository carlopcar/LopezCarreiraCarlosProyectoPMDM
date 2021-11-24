package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lopezcarreiracarlosproyectopmdm.App.Companion.peliculas
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityDetallePeliculaBinding
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

        binding.tvDDirector.text="Director: \n" +pelicula.director
        binding.tvDGenero.text="Género: \n" +pelicula.genero
        binding.tvDAno.text="Año del estreno: \n" +pelicula.ano
        binding.tvDDuracion.text="Duración: \n" + pelicula.duracion
        binding.tvDMusica.text="Dirección Musical: \n" + pelicula.musica
        binding.tvDFotografia.text="Fotografía: \n"+pelicula.fotografia
        binding.tvDPais.text="País: \n"+pelicula.pais
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

                val intent = Intent(this,EditarActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Editar película", Toast.LENGTH_SHORT).show()

                return true
            }

            R.id.accion_borrar -> {

                val builder = AlertDialog.Builder(this)
                val dialog = builder.setTitle("Borrar película").setMessage("Una vez eliminada no " +
                        "hay vuelta atrás, ¿Estás seguro?")
                    .setPositiveButton("Aceptar" , {dialog,id ->
                        peliculas.remove(pelicula)
                        Toast.makeText(this, "Película eliminada", Toast.LENGTH_SHORT).show()
                        finish()})
                    .setNegativeButton("Cancelar" , null).create()

                dialog.show()

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}