package com.demo.tunghoang.fxrdp

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene

import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("view/home.fxml"))
        stage.title = "Hello"
        stage.scene = Scene(root)
        stage.show()
    }

    fun main() {
        launch()
    }
}

fun main() {
    Main().main()
}