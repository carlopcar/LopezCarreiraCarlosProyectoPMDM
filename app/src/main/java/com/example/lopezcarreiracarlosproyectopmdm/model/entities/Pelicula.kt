package com.example.lopezcarreiracarlosproyectopmdm.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    var id: Long,
    @SerializedName("title")var titulo: String,
    @SerializedName("directorFarstname")var director: String,
    @SerializedName("genre")var genero: String,
    @SerializedName("rating")var nota: String,
    @SerializedName("imageUrl")var url: String,
    @SerializedName("releaseYear")var ano: String,
    @SerializedName("runtimeMinutes")var duracion: String,
    @SerializedName("musicDirector")var musica: String,
    @SerializedName("photographyDirector")var fotografia: String,
    @SerializedName("country")var pais: String,
    @SerializedName("description")var descripcion: String,
    @SerializedName("directorPhone")var numDirector: String
) : Serializable