package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.RetrofitClient.apiRetrofit
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityDetallePeliculaBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetallePeliculaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeliculaBinding
    private lateinit var pelicula: Pelicula
    companion object {
        lateinit var preferences: Preferences
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pelicula = intent.extras?.get("pelicula") as Pelicula

        title = pelicula.titulo
        binding.tvDDirector.text = "Director: \n\n" + pelicula.director
        binding.tvDGenero.text = "Género: \n\n" + pelicula.genero
        binding.tvDAno.text = "Año del estreno: \n\n" + pelicula.ano
        binding.tvDDuracion.text = "Duración: \n\n" + pelicula.duracion + "´"
        binding.tvDMusica.text = "Dirección Musical: \n\n" + pelicula.musica
        binding.tvDFotografia.text = "Fotografía: \n\n" + pelicula.fotografia
        binding.tvDPais.text = "País: \n\n" + pelicula.pais
        binding.tvDDescripcion.text = "Sinopsis: \n\n" + pelicula.descripcion


        Picasso.get().load(pelicula.url).into(binding.ivPelicula)

    }

    //Utilizo el onStop para forzar que al editar una película volvamos directamente a la lista
    //de películas ya que entiendo que el usuario debe presuponer que la función editar se realiza
    //correctamente y no tiene sentido volver al detalle para comprobarlo.
    override fun onStop() {
        super.onStop()
        onBackPressed()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalle_peliculas, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.accion_llamar -> {

                val builder = AlertDialog.Builder(this)
                val dialog = builder.setTitle("LLamar al director").setMessage(
                    "Estás a punto de llamar al director de la película, ¿Estás seguro?")
                    .setPositiveButton("Aceptar") { _, _ ->
                        val num: String = pelicula.numDirector
                        if (!TextUtils.isEmpty(num)) {
                            val dial = "tel:$num"
                            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
                        } else {
                            Toast.makeText(this, "Imposible realizar la llamada", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .setNegativeButton("Cancelar", null).create()

                dialog.show()

                return true
            }

            R.id.accion_editar -> {

                val intent = Intent(this, EditarActivity::class.java)


                intent.putExtra("id", pelicula.id)

                startActivity(intent)
                Toast.makeText(this, "Editar película", Toast.LENGTH_SHORT).show()

                return true
            }

            R.id.accion_borrar -> {

                val builder = AlertDialog.Builder(this)
                val dialog = builder.setTitle("Borrar película").setMessage(
                    "Una vez eliminada no hay vuelta atrás, ¿Estás seguro?")
                    .setPositiveButton("Aceptar") { _, _ ->

                        //Retrofit

                        preferences = Preferences(this)
                        val context = this

                        val token = "Bearer " + preferences.recuperarDatosToken("")

                        val llamadaApi: Call<Unit> = apiRetrofit.borrar(token , pelicula.id)
                        llamadaApi.enqueue(object: Callback<Unit> {

                            override fun onResponse(call: Call<Unit>, response: Response<Unit>
                            ) {

                                val peliculas = response.body()

                                if (response.code() > 299 || response.code() < 200 || peliculas == null) {

                                    Toast.makeText(context,"No ha sido posible cargar la lista de películas", Toast.LENGTH_SHORT).show()

                                } else {

                                    Toast.makeText(context, "Película eliminada", Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                            }

                            override fun onFailure(call: Call<Unit>, t: Throwable) {
                                Log.d("Prueba", t.message.toString())
                            }
                        })

                    }
                    .setNegativeButton("Cancelar", null).create()

                dialog.show()


                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}