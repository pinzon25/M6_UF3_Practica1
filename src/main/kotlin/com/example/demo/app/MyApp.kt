package com.example.demo.app

import com.example.demo.view.MainView
import tornadofx.App
import tornadofx.UIComponent
import tornadofx.Workspace
import tornadofx.importStylesheet

class MyApp: App(Workspace::class){

    override fun onBeforeShow(view: UIComponent) {
        workspace.dock<MenuPrincipal>()
    }
}





