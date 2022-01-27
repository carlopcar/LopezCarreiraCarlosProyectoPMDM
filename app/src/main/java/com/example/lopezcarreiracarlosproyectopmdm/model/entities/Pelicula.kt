package com.example.lopezcarreiracarlosproyectopmdm.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pelicula(
    var id: Long,
    @SerializedName("title")var titulo: String,
    var director: String,
    var genero: String,
    @SerializedName("rating")var nota: String,
    var url: String,
    var ano: String,
    @SerializedName("runtimeMinutes")var duracion: String,
    var musica: String,
    var fotografia: String,
    var pais: String,
    var descripcion: String,
    var numDirector: String
) : Serializable