package com.example.lopezcarreiracarlosproyectopmdm.model.dao.retrofit

import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Token
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Usuario
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @POST("users/signup")
    fun registrarse(@Body usuario:Usuario):Call<Unit>

    @POST("users/login")
    fun login(@Body usuario:Usuario):Call<Token>

    @GET("movies")
    fun getPeliculas(@Header("Authorization")token:String): Call<List<Pelicula>>

    @POST("movies")
    fun crear(@Header("Authorization")token:String,
                @Body pelicula: Pelicula): Call<Unit>

    @GET("movies/{id}")
    fun getById(@Header("Authorization") token:String,
               @Path ("id") id: String?):Call<Pelicula>

    @PUT("movies")
    fun editar(@Header("Authorization") token:String,
                @Body pelicula:Pelicula):Call<Unit>

    @DELETE("movies/{id}")
    fun borrar(@Header("Authorization") token:String,
               @Path ("id") id: String?):Call<Unit>


}