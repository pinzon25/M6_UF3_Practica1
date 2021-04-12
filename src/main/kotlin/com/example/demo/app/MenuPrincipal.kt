package com.example.demo.app

import javafx.collections.FXCollections
import javafx.scene.control.TextArea
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import tornadofx.*

class MenuPrincipal: View(){
    override val root: AnchorPane by fxml()
    var work: Workspace = MyApp().workspace
    var llistatConsoles: MutableList<Consola> = ArrayList()
    var llistatJocs: MutableList<Joc> = ArrayList()
    var SelCons:Consola?=null
    var JocSel:Joc?=null
    val controller: JocsController by inject()
    val logoConsola:ImageView by fxid("Iv_Logoplataforma")
    val logoJoc:ImageView by fxid("Iv_Portadajoc")
    val Adescripcio:TextArea by fxid("Ta_DescripcioJoc")
    var C: javafx.scene.control.TableView<Consola>? = null
    var J: javafx.scene.control.TableView<Joc>? = null
    var idConsola:Int?=null

    init{
        llistatConsoles = controller.carregaConsoles()
        println("Llistat consoles: "+llistatConsoles)
        println("Llistat de jocs: "+llistatJocs)
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
                    //SelCons=C!!.selectedItem
                    SelCons=C!!.selectionModel.selectedItem
                    println("Consola escollida: "+SelCons)
                    //llistatJocs=controller.carregaJocsPerPlataforma(SelCons!!.id_consola)
                    //Obtenim el arraylist amb els jocs corresponent a la consola seleccionada.
                    //llistatJocs=controller.carregaJocs(SelCons!!.id_consola)
                    //model = editModel
                    logoConsola.image= Image(SelCons!!.logo_consola) //Canviem l'icona de la consola dinamicament segons quina haguem escollit.

                    idConsola=SelCons!!.id_consola
                    println("id consola: "+idConsola!!)
                }
            }




                C?.onUserSelect {
                    llistatJocs=controller.carregaJocsPerPlataforma(idConsola)
                    var j = FXCollections.observableArrayList(llistatJocs.observable())

                    println("Llistat de jocs obtinguts amb el id de la consola: "+j)
                    J = tableview(j) { //column("Id", Alumne::idProperty)
                        column("Nom", Joc::nomProperty).minWidth(240.0).isResizable
                        //column("", Joc::descripcioProperty)

                        prefHeight = 401.0
                        prefWidth = 240.0
                        layoutX = 120.0
                        layoutY = 105.0
                        isEditable = true
                        enableCellEditing()
                        enableDirtyTracking()

                        onUserSelect {
                            JocSel = J!!.selectionModel.selectedItem
                            logoJoc.image=Image(J!!.selectionModel.selectedItem.portada_joc)
                            Adescripcio.text= JocSel!!.descripcio_joc
                        }
                        //model = editModel
                    }
                }



        }







    }















}
