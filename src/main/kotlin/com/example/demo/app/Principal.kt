package com.example.demo.app

import javafx.collections.FXCollections
import javafx.scene.control.TableView
import javafx.scene.layout.AnchorPane
import javafx.scene.paint.*
import javafx.scene.shape.Rectangle
import javafx.util.Duration.seconds
import tornadofx.*
import java.time.Duration
import javax.swing.text.html.ImageView

class Principal: View("GestioAlumnes") {
    override val root: AnchorPane by fxml()
    val L: ImageView by fxid("Im_logo")
    var work: Workspace = MyApp().workspace
    var llistatAlumnes: MutableList<Alumne> = ArrayList()
    val controller: AlumneController by inject()
    var t: javafx.scene.control.TableView<Alumne>? = null
    var st:MutableList<Stop> = ArrayList()
    var R:Rectangle?=null
    val RB: Rectangle by fxid("Rc_Background")


    init {
        /*
        st.add(Stop(0.0,Color.rgb(228,1,248)))
        st.add(Stop(0.5,Color.rgb(12,66,12)))
        st.add(Stop(1.0,Color.rgb(0,0,0)))

        var P:LinearGradient = LinearGradient(80.0,0.0,70.0,70.0,true,CycleMethod.NO_CYCLE,st)
        var pint:Paint=P
        // RB!!.setFill(pint)
        RB.isVisible=true
        */
        llistatAlumnes = controller.carregaAlumnes()
        //println(llistatAlumnes)
        var a = FXCollections.observableArrayList(llistatAlumnes.observable())

        with(root) {

        println(st)

            t = tableview(a) { //column("Id", Alumne::idProperty)
                column("Nom", Alumne::nomProperty).makeEditable().minWidth(115).isResizable
                column("Cognoms", Alumne::cognomsProperty).makeEditable().minWidth(115).isResizable
                column("Edat", Alumne::edatProperty).makeEditable().minWidth(115).isResizable


                prefHeight = 365.0
                prefWidth = 345.0
                layoutX = 250.0
                layoutY = 100.0
                isEditable = true
                enableCellEditing()
                enableDirtyTracking()
                //model = editModel
            }

        }



        work.createButton.setOnMouseClicked { println("Has clicat al boto d'afegir!!!") }
        work.deleteButton.setOnMouseClicked { println("Has clicat al boto d'esborrar!!!") }


    }
}
