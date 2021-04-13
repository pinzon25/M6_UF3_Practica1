package com.example.demo.app

import com.example.demo.view.MainView
import com.sun.java.accessibility.util.GUIInitializedMulticaster.add
import tornadofx.App
import tornadofx.UIComponent
import tornadofx.Workspace
import tornadofx.importStylesheet

class MyApp: App(Workspace::class){

    init{


    }
    override fun onBeforeShow(view: UIComponent) {
        workspace.dock<Principal>()


    }


}





