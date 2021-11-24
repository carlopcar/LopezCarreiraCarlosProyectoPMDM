package com.example.lopezcarreiracarlosproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityEditarBinding

class EditarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //pelicula = intent.extras?.get("pelicula") as Pelicula

        //binding.tiedTitulo.setText(pelicula.titulo)
        //binding.tiedDirector.setText(pelicula.director)
        //binding.tiedGenero.setText(pelicula.genero)
        //binding.tiedNota.setText(pelicula.nota)
        //binding.tiedAno.setText(pelicula.ano)
        //binding.tiedDuracion.setText(pelicula.duracion)
        //binding.tiedMusica.setText(pelicula.musica)
        //binding.tiedFoto.setText(pelicula.fotografia)
        //binding.tiedPais.setText(pelicula.pais)
        //binding.tiedDesc.setText(pelicula.descripcion)
        //binding.tiedImagen.setText(pelicula.url)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_editar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.accion_guardar -> {
                return false
            }

            R.id.accion_cancelar -> {
                return false
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}