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
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mxfLOWnHnSlbdraKfzRn5mqoqk7.jpg",
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
            "Comedia / Drama",
            "8.0",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/edPWyHqknFuxFY3sdmC3LtJITWC.jpg",
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
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m4gYCeV4GfGDw4PpMgU9kFIaNxP.jpg",
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
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oNtArC5z3Z806aE19zePo6wJZN3.jpg",
            "2000",
            "104'",
            "John Murphy",
            "Tim Maurice-Jones",
            "Reino Unido",
            "Franky es un ladrón de diamantes que tiene que entregar un valioso ejemplar " +
                    "a su jefe Avi, pero, antes de hacerlo, se deja convencer por un tal Boris para" +
                    " apostar en un combate ilegal de boxeo. En realidad, se trata de una trampa" +
                    " para arrebatarle el diamante. Cuando Avi se entera, contrata a Tony para" +
                    " encontrar a Franky y al diamante. Descubierto el triste destino de Franky," +
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
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xF14Liu2qQgagvAMK6l1UL1MKb8.jpg",
            "2003",
            "120'",
            "Jo Yeong-wook",
            "Chung Chung-hoon",
            "Corea del Sur",
            "Oh Dae-su es un hombre de negocios coreano que un día es secuestrado y" +
                    " confinado durante años en una celda en la que sólo hay una televisión." +
                    " Y, sin embargo, ignora por qué razón está allí... Segunda parte de la" +
                    " \"trilogía de la venganza\" de Park Chan-wook."
        ),
        Pelicula(
            0,
            "The Silence of the Lambs",
            "Jonathan Demme",
            "Triller / Intriga",
            "8.2",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8FdQQ3cUCs9goEOr1qUFaHackoJ.jpg",
            "1991",
            "115'",
            "Howard Shore",
            "Tak Fujimoto",
            "Estados Unidos",
            "El FBI busca a \"Buffalo Bill\", un asesino en serie que mata a sus víctimas," +
                    " todas adolescentes, después de prepararlas minuciosamente y arrancarles la" +
                    " piel. Para poder atraparlo recurren a Clarice Starling, una brillante" +
                    " licenciada universitaria, experta en conductas psicópatas, que aspira" +
                    " a formar parte del FBI. Siguiendo las instrucciones de su jefe, Jack Crawford," +
                    " Clarice visita la cárcel de alta seguridad donde el gobierno mantiene " +
                    "encerrado al Dr. Hannibal Lecter, antiguo psicoanalista y asesino, dotado de " +
                    "una inteligencia superior a la normal. Su misión será intentar sacarle " +
                    "información sobre los patrones de conducta del asesino que están buscando."
        ),
        Pelicula(
            0,
            "Gladiator",
            "Ridley Scott",
            "Acción / Drama",
            "8",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4Ij6EoZuq4mKnByXj6i5YRqq4If.jpg",
            "2000",
            "150'",
            "Hans Zimmer",
            "John Mathieson",
            "Estados Unidos",
            "En el año 180, el Imperio Romano domina todo el mundo conocido. Tras una" +
                    " gran victoria sobre los bárbaros del norte, el anciano emperador Marco" +
                    " Aurelio (Richard Harris) decide transferir el poder a Máximo (Russell Crowe)," +
                    " bravo general de sus ejércitos y hombre de inquebrantable lealtad al imperio." +
                    " Pero su hijo Cómodo (Joaquin Phoenix), que aspiraba al trono, no lo acepta y" +
                    " trata de asesinar a Máximo."
        )
    )

}