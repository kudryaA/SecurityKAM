package kam.design.component

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import kam.Main

class Frame(val path: String): Stage() {

    companion object {
        private val pathImage = "/kam/design/image/logo.png"
    }

    val loader: FXMLLoader = FXMLLoader(Main::class.java.getResource(path))

    init {
        icons.add(Image(pathImage))
        val root: Parent = loader.load()
        title = "SecurityKAM"
        val scene = Scene(root)
        setScene(scene)
    }
}