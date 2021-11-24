package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lopezcarreiracarlosproyectopmdm.App
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityEditarBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula

class EditarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarBinding
    private lateinit var pelicula: Pelicula

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pelicula = intent.extras?.get("pelicula") as Pelicula?

        if (pelicula != null) {

            binding.tiedTitulo.setText(pelicula.titulo)
            binding.tiedDirector.setText(pelicula.director)
            binding.tiedGenero.setText(pelicula.genero)
            binding.tiedNota.setText(pelicula.nota)
            binding.tiedAno.setText(pelicula.ano)
            binding.tiedDuracion.setText(pelicula.duracion)
            binding.tiedMusica.setText(pelicula.musica)
            binding.tiedFoto.setText(pelicula.fotografia)
            binding.tiedPais.setText(pelicula.pais)
            binding.tiedDesc.setText(pelicula.descripcion)
            binding.tiedImagen.setText(pelicula.url)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_editar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.accion_guardar -> {

                val builder = AlertDialog.Builder(this)
                val dialog = builder.setTitle("Actualizar película").setMessage(
                    "¿Estás seguro de querer añadirla a tu lista?")
                    .setPositiveButton("Aceptar") { _, _ ->
                        App.peliculas.remove(pelicula)
                        App.peliculas.add(Pelicula(0,binding.tiedTitulo.text.toString()
                            ,binding.tiedDirector.text.toString()
                            ,binding.tiedGenero.text.toString()
                            ,binding.tiedNota.text.toString()
                            ,binding.tiedAno.text.toString()
                            ,binding.tiedDuracion.text.toString()
                            ,binding.tiedMusica.text.toString()
                            ,binding.tiedFoto.text.toString()
                            ,binding.tiedPais.text.toString()
                            ,binding.tiedDesc.text.toString()
                            ,binding.tiedImagen.text.toString()
                            ,"+34627892520"))
                        Toast.makeText(this, "Lista actulizada", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                    .setNegativeButton("Cancelar", null).create()

                dialog.show()

                return true

            }

            R.id.accion_cancelar -> {

                val intent = Intent(this, PeliculasActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Acción cancelada", Toast.LENGTH_SHORT).show()

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}