package com.example.demo.app

import javafx.beans.property.Property
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.Commit
import tornadofx.ItemViewModel

//data class Consola(var id_consola:Int, var nom_consola:String, var logo_consola:String) {
data class Joc(var id_joc:Int, var id_plataforma:Int, var nom_joc:String, var descripcio_joc:String, var portada_joc:String) {
    val idProperty = SimpleIntegerProperty(id_joc)

    val plataformaProperty = SimpleIntegerProperty(id_plataforma)

    val nomProperty = SimpleStringProperty(nom_joc)

    val descripcioProperty = SimpleStringProperty(descripcio_joc)

    val portadaProperty = SimpleStringProperty(portada_joc)
}

class JocModel(joc:Joc?) : ItemViewModel<Joc>(joc){
    val id = bind(Joc::idProperty)
    val plataforma = bind(Joc::plataformaProperty)
    val nom = bind(Joc::nomProperty)
    val descripcio = bind(Joc::descripcioProperty)
    val portada = bind(Joc::portadaProperty)
}
