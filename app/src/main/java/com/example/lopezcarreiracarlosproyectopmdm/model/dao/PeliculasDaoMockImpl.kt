package com.example.lopezcarreiracarlosproyectopmdm.model.dao

import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula

class PeliculasDaoMockImpl : PeliculasDao {

    override fun getTodos()= listOf(
        Pelicula(
            0,
            "The Pianist",
            "Roman Polanski",
            "Drama",
            "8.2",
            "https://pics.filmaffinity.com/the_pianist_le_pianiste-978132965-large.jpg",
            "2002",
            "148'",
            "Wojciech Kilar",
            "Pawel Edelman",
            "Reino Unido",
            "Wladyslaw Szpilman, un brillante pianista polaco de origen judío, vive con su" +
                    " familia en el ghetto de Varsovia. Cuando, en 1939, los alemanes invaden Polonia," +
                    " consigue evitar la deportación gracias a la ayuda de algunos amigos. Pero tendrá" +
                    " que vivir escondido y completamente aislado durante mucho tiempo, y para" +
                    " sobrevivir tendrá que afrontar constantes peligros."
        ),
        Pelicula(
            0,
            "Intouchables",
            "Olivier Nakache, Eric Toledano",
            "Cmedia / Drama",
            "8.0",
            "https://pics.filmaffinity.com/intouchables-218166359-large.jpg",
            "2011",
            "109'",
            "Ludovico Einaudi",
            "Mathieu Vadepied",
            "Francia",
            "Philippe, un aristócrata millonario que se ha quedado tetrapléjico a causa de" +
                    " un accidente de parapente, contrata como cuidador a domicilio a Driss, un" +
                    " inmigrante de un barrio marginal recién salido de la cárcel. Aunque, a primera" +
                    " vista, no parece la persona más indicada, los dos acaban logrando que convivan" +
                    " Vivaldi y Earth Wind and Fire, la elocuencia y la hilaridad, los trajes de" +
                    " etiqueta y el chándal. Dos mundos enfrentados que, poco a poco, congenian " +
                    "hasta forjar una amistad tan disparatada, divertida y sólida como inesperada," +
                    " una relación única en su especie de la que saltan chispas."
        ),
        Pelicula(
            0,
            "Big Fish",
            "Tim Burton",
            "Drama",
            "7.9",
            "https://pics.filmaffinity.com/big_fish-838287233-large.jpg",
            "2003",
            "126'",
            "Daanny Elfman",
            "Philippe Rousselot",
            "Estados Unidos",
            "William Bloom (Billy Crudup) no tiene muy buena relación con su padre " +
                    "(Albert Finney), pero tras enterarse de que padece una enfermedad terminal, " +
                    "regresa a su hogar para estar a su lado en sus últimos momentos. Una vez más," +
                    " William se verá obligado a escucharlo mientras cuenta las interminables" +
                    " historias de su juventud. Pero, en esta ocasión, tratará de averiguar cosas" +
                    " que le permitan conocer mejor a su padre, aunque para ello tendrá que separar" +
                    " claramente realidad y fantasía, elementos que aparecen siempre mezclados en" +
                    " los relatos de su progenitor."
        ),
        Pelicula(
            0,
            "Snatch. Cerdos y diamantes",
            "Guy Ritchie",
            "Comedia Negra",
            "7.9",
            "https://pics.filmaffinity.com/snatch-921179475-large.jpg",
            "2000",
            "104'",
            "John Murphy",
            "Tim Maurice-Jones",
            "Reino Unido",
            "Franky es un ladrón de diamantes que tiene que entregar un valioso ejemplar " +
                    "a su jefe Avi, pero, antes de hacerlo, se deja convencer por un tal Boris para" +
                    " apostar en un combate ilegal de boxeo. En realidad, se trata de una trampa" +
                    " para arrebatarle el diamante. Cuando Avi se entera, contrata a Tony para" +
                    "encontrar a Franky y al diamante. Descubierto el triste destino de Franky," +
                    " la recuperación de la gema desaparecida provoca una situación caótica, " +
                    "donde el engaño, el chantaje y el fraude se mezclan de forma sangrienta" +
                    " con perros, diamantes, boxeadores y gran variedad de armas."
        ),
        Pelicula(
            0,
            "OldBoy",
            "Park Chan-wook",
            "Triller / Intriga",
            "7.9",
            "https://pics.filmaffinity.com/oldboy-520509097-large.jpg",
            "2003",
            "120'",
            "Jo Yeong-wook",
            "Chung Chung-hoon",
            "Corea del Sur",
            "Oh Dae-su es un hombre de negocios coreano que un día es secuestrado y" +
                    " confinado durante años en una celda en la que sólo hay una televisión." +
                    " Y, sin embargo, ignora por qué razón está allí... Segunda parte de la" +
                    " \"trilogía de la venganza\" de Park Chan-wook."
        )
    )

}