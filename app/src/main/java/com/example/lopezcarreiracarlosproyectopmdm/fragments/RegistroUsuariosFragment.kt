package com.example.lopezcarreiracarlosproyectopmdm.fragments

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lopezcarreiracarlosproyectopmdm.RetrofitClient
import com.example.lopezcarreiracarlosproyectopmdm.databinding.FragmentRegistroUsuariosBinding
import com.example.lopezcarreiracarlosproyectopmdm.fragments.LoginFragment.Companion.preferences
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class RegistroUsuariosFragment : Fragment() {

    private lateinit var binding: FragmentRegistroUsuariosBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentRegistroUsuariosBinding.inflate(inflater, container, false)

        activity?.title = "Registro Usuarios"

        binding.btRegistrar.setOnClickListener {


            if (comprobarDatos()) {

                val email = binding.etRegistroEmail.text.toString().trim()
                val psw = binding.etRegistroPsw.text.toString().trim()
                val u = Usuario(null,email, psw)

                val signUpCall = RetrofitClient.apiRetrofit.registrarse(u)

                signUpCall.enqueue(object: Callback<Unit> {

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()

                    }

                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        Log.d("respuesta: onResponse", response.toString())

                        if (response.code() > 299 || response.code() < 200) {

                            Toast.makeText(activity,"No se ha podido registrar el usuario", Toast.LENGTH_SHORT).show()

                        } else {

                            //Volver a Login
                            preferences.guardarEmail(email)
                            activity?.onBackPressed()

                        }

                    }
                })


            }
        }
        return binding.root
    }


    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun comprobarDatos(): Boolean {

        val nombreUsuario = binding.etRegistroNombreUsuario.text.toString().trim()
        val email = binding.etRegistroEmail.text.toString().trim()
        val telefono = binding.etTelefono.text.toString().trim()
        val psw = binding.etRegistroPsw.text.toString().trim()
        val pswrep = binding.etRegistroRepPsw.text.toString().trim()

        if (!validarEmail(email)) {
            //Si el email es incorrecto
            Toast.makeText(activity, "El email no es correcto", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (psw.length < 8 || psw.length > 16) {
            //Comprobamos la longitud de la contraseña
            Toast.makeText(activity, "La contraseña no tiene la longitud correcta", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (psw != pswrep) {
            //Comprobamos que las contraseñas sean iguales
            Toast.makeText(activity, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (TextUtils.isEmpty(nombreUsuario) ||
            TextUtils.isEmpty(email) ||
            TextUtils.isEmpty(telefono) ||
            TextUtils.isEmpty(psw) ||
            TextUtils.isEmpty(pswrep)
        ) {

            Toast.makeText(activity, "Debes rellenar todos los datos", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }


}


