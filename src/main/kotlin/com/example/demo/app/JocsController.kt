package com.example.demo.app

import tornadofx.Controller
import java.sql.Connection

class JocsController : Controller() {

    var c: Connection = Connexio().connexio()


    fun carregaConsoles(): MutableList<Consola> {
        //var c: Connection = Connexio().connexio()
        var llistatConsoles: MutableList<Consola> = ArrayList()
        val ps = c.createStatement().executeQuery("SELECT * FROM Consola")
        while (ps.next()) {
            val id = ps.getInt("id_consola")
            val nom = ps.getString("Nom")
            val logo = ps.getString("logo")

            val co = Consola(id, nom, logo)

            llistatConsoles.add(co)
        }
        return llistatConsoles
        //c.close()
    }

    fun carregaJocs(): MutableList<Joc> {
        var llistatJocs: MutableList<Joc> = ArrayList()
        var j: Joc? = null
        val ps = c.createStatement().executeQuery("SELECT * FROM Joc")
        while (ps.next()) {
            val id = ps.getInt("id_joc")
            val plataforma = ps.getInt("id_plataforma")
            val nom = ps.getString("nom")
            val descripcio = ps.getString("descripcio")
            val portada = ps.getString("portada")

            j = Joc(id, plataforma, nom, descripcio, portada)

            llistatJocs.add(j)

        }
        return llistatJocs //Retornem els jocs segons Consola.
        //c.close()
    }

    fun carregaJocsPerPlataforma(idCons:Int?): MutableList<Joc> {
        var llistatJocsPlataforma: MutableList<Joc> = ArrayList()
        var j: Joc? = null
        val ps = c.createStatement().executeQuery("SELECT * FROM Joc")
        while (ps.next()) {
            val id = ps.getInt("id_joc")
            val plataforma = ps.getInt("id_plataforma")
            val nom = ps.getString("nom")
            val descripcio = ps.getString("descripcio")
            val portada = ps.getString("portada")

            j = Joc(id, plataforma, nom, descripcio, portada)

            if (idCons?.equals(j.id_plataforma) == true) {
                llistatJocsPlataforma.add(j)
            }
        }
        return llistatJocsPlataforma //Retornem els jocs segons Consola.
    //c.close()
    }



    //fun
}