package kam.design.contoller

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import kam.design.PathToView
import kam.design.closeStage
import kam.design.component.Frame
import kam.write

class ListOfEmail {
    @FXML
    private var textAreaEmail: TextArea? = null

    @FXML
    private fun clickOk() {
        val frame = Frame(PathToView.SetPassword.path)
        frame.isResizable = false
        frame.show()
        write("list", textAreaEmail!!.text)
        closeStage(textAreaEmail!!)
    }
}