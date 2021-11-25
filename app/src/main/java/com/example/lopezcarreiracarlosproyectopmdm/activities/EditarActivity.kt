package com.example.lopezcarreiracarlosproyectopmdm.activities

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
                val dialog = builder.setTitle("Actualizar películas").setMessage(
                    "¿Estás seguro de querer añadirla a tu lista?")
                    .setPositiveButton("Aceptar") { _, _ ->
                        if (pelicula == null) {
                            App.peliculas.remove(pelicula)
                            App.peliculas.add(
                                Pelicula(
                                    0,
                                    binding.tiedTitulo.text.toString().trim(),
                                    binding.tiedDirector.text.toString().trim(),
                                    binding.tiedGenero.text.toString().trim(),
                                    binding.tiedNota.text.toString().trim(),
                                    binding.tiedAno.text.toString().trim(),
                                    binding.tiedDuracion.text.toString().trim(),
                                    binding.tiedMusica.text.toString().trim(),
                                    binding.tiedFoto.text.toString().trim(),
                                    binding.tiedPais.text.toString().trim(),
                                    binding.tiedDesc.text.toString().trim(),
                                    binding.tiedImagen.text.toString().trim(),
                                    "+34627892520"
                                )
                            )
                            Toast.makeText(this, "Lista actulizada", Toast.LENGTH_SHORT).show()
                            finish()
                        }else{
                            App.peliculas.add(
                                Pelicula(
                                    0,
                                    binding.tiedTitulo.text.toString().trim(),
                                    binding.tiedDirector.text.toString().trim(),
                                    binding.tiedGenero.text.toString().trim(),
                                    binding.tiedNota.text.toString().trim(),
                                    binding.tiedAno.text.toString().trim(),
                                    binding.tiedDuracion.text.toString().trim(),
                                    binding.tiedMusica.text.toString().trim(),
                                    binding.tiedFoto.text.toString().trim(),
                                    binding.tiedPais.text.toString().trim(),
                                    binding.tiedDesc.text.toString().trim(),
                                    binding.tiedImagen.text.toString().trim(),
                                    "+34627892520"
                                )
                            )
                            Toast.makeText(this, "Lista actulizada", Toast.LENGTH_SHORT).show()
                            finish()
                        }
                    }
                    .setNegativeButton("Cancelar", null).create()

                dialog.show()

                return true

            }

            R.id.accion_cancelar -> {

                onBackPressed()
                Toast.makeText(this, "Acción cancelada", Toast.LENGTH_SHORT).show()

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}