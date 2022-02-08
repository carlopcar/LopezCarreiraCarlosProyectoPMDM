package com.example.lopezcarreiracarlosproyectopmdm.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.RetrofitClient
import com.example.lopezcarreiracarlosproyectopmdm.activities.PeliculasActivity
import com.example.lopezcarreiracarlosproyectopmdm.databinding.FragmentLoginBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Token
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var con:Context
    companion object {
        lateinit var preferences: Preferences
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =  FragmentLoginBinding.inflate(inflater, container, false)
        con = requireContext().applicationContext

        activity?.title = "Login"

        //Activar boton acceder
        binding.btLoginAcceder.isEnabled = true

        //Inicializamos las preferences
        preferences = Preferences(con)

        //Si hay token iniciamos la app directamente.

        if (!preferences.recuperarDatosToken("").isNullOrEmpty()){
            val intent = Intent(con, PeliculasActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

            //Método al pulsar el botón LOGIN
            binding.btLoginAcceder.setOnClickListener {

                //Desactivar boton acceder y visibilidad progresbar
                binding.btLoginAcceder.isEnabled = false
                binding.progressBar.visibility = View.VISIBLE

                val email = binding.etLoginEmail.text.toString().trim()
                val contrasenha = binding.etLoginPsw.text.toString().trim()


                if (email == "") {
                    binding.etLoginEmail.error = "Introduce un email"
                    binding.progressBar.visibility = View.GONE
                    binding.btLoginAcceder.isEnabled = true
                } else if (contrasenha == "") {
                    binding.etLoginPsw.error = "Introduce una contraseña"
                    binding.progressBar.visibility = View.GONE
                    binding.btLoginAcceder.isEnabled = true
                } else {

                    val u = Usuario(null, email, contrasenha)

                    val loginCall = RetrofitClient.apiRetrofit.login(u)

                    loginCall.enqueue(object : Callback<Token> {
                        override fun onFailure(call: Call<Token>, t: Throwable) {
                            Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()
                            binding.progressBar.visibility = View.GONE
                            binding.btLoginAcceder.isEnabled = true
                        }

                        override fun onResponse(call: Call<Token>, response: Response<Token>) {
                            Log.d("respuesta: onResponse", response.toString())

                            if (response.code() > 299 || response.code() < 200) {

                                Toast.makeText(activity, "No se ha podido iniciar sesión", Toast.LENGTH_SHORT).show()
                                binding.progressBar.visibility = View.GONE
                                binding.btLoginAcceder.isEnabled = true

                            } else {

                                val token = response.body()?.token.toString()

                                //Guardo en sharedPreferences el token y el email
                                preferences.guardarToken(token)
                                //Inicio nueva activity
                                val intent = Intent(con, PeliculasActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        }
                    })
                }
            }


        //Método al pulsar el textview REGISTRO
        binding.tvLoginRegistro.setOnClickListener {

            val ft = activity?.supportFragmentManager?.beginTransaction()
            ft?.replace(R.id.contenedorFragments , RegistroUsuariosFragment())
            ft?.addToBackStack(null)
            ft?.commit()

        }

        return binding.root
    }


    override fun onResume() {
        super.onResume()

        val mail = preferences.recuperarDatosEmail("").toString()
        binding.etLoginEmail.setText(mail)
    }

}