package kam.design

import javafx.scene.Node
import javafx.stage.Stage
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.Alert



fun closeStage(node: Node) {
    (node.scene.window as Stage).close()
}

fun showDialog(text: String) {
    val alert = Alert(AlertType.INFORMATION)
    alert.title = "Information Dialog"
    alert.headerText = null
    alert.contentText = text
    alert.show()
}