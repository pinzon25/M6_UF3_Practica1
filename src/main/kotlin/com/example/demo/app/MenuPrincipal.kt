package com.example.demo.app

import javafx.collections.FXCollections
import javafx.scene.layout.AnchorPane
import tornadofx.*

class MenuPrincipal: View(){
    override val root: AnchorPane by fxml()
    var work: Workspace = MyApp().workspace
    var llistatConsoles: MutableList<Consola> = ArrayList()
    var llistatJocs: MutableList<Joc> = ArrayList()
    var SelCons:Consola?=null
    val controller: JocsController by inject()
    var C: javafx.scene.control.TableView<Consola>? = null
    var J: javafx.scene.control.TableView<Joc>? = null

    init{
        llistatConsoles = controller.carregaConsoles()
        println(llistatConsoles)
        //println(llistatAlumnes)
        var c = FXCollections.observableArrayList(llistatConsoles.observable())

        with(root){
            C = tableview(c) { //column("Id", Alumne::idProperty)
                column("", Consola::nomProperty)//.makeEditable()//.minWidth(115).isResizable
                prefHeight = 401.0
                prefWidth = 100.0
                layoutX = 20.0
                layoutY = 105.0
                isEditable = true
                enableCellEditing()
                enableDirtyTracking()
                onUserSelect {
                    SelCons=C?.selectedItem
                    //Obtenim el arraylist amb els jocs corresponent a la consola seleccionada.
                    //llistatJocs=controller.carregaJocs(SelCons!!.id_consola)
                    //model = editModel
                    println("Element seleccionat: " + SelCons)
                }

            }


           /* J = tableview(j) { //column("Id", Alumne::idProperty)
                column("", Joc::nomProperty)//.makeEditable()//.minWidth(115).isResizable
                column("", Joc::descripcioProperty)

                prefHeight = 401.0
                prefWidth = 100.0
                layoutX = 20.0
                layoutY = 105.0
                isEditable = true
                enableCellEditing()
                enableDirtyTracking()
                //model = editModel
            }*/

        }







    }















}
