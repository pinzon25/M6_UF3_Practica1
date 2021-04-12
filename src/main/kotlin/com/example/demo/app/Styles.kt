package com.example.demo.app

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val rectbackground by cssclass()
    }

    //var R: Rectangle? = null

    init {
       /* rectbackground{
            backgroundColor += c("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #dc143c, #661a33)")
        }*/

        /*label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }*/



    }

}
