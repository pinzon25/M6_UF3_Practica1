package com.example.demo.app

import javafx.beans.property.Property
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.Commit
import tornadofx.ItemViewModel

data class Consola(var id_consola:Int, var nom_consola:String, var logo_consola:String) {

    val idProperty = SimpleIntegerProperty(id_consola)

    val nomProperty = SimpleStringProperty(nom_consola)

    val logoProperty = SimpleStringProperty(logo_consola)
}

class ConsolaModel(consola:Consola?) : ItemViewModel<Consola>(consola){
    val id = bind(Consola::idProperty)
    val nom = bind(Consola::nomProperty)
    val logo = bind(Consola::logoProperty)
}
