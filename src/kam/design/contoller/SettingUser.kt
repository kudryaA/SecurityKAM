package kam.design.contoller

import javafx.fxml.FXML
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import kam.design.PathToView
import kam.design.closeStage
import kam.design.component.Frame
import kam.struct.Email
import kam.write

class SettingUser {
    @FXML
    private var textFieldEmail: TextField? = null
    @FXML
    private var textFieldPassword: PasswordField? = null

    @FXML
    private fun clickOk() {
        Email.instance.email = textFieldEmail!!.text
        Email.instance.password = textFieldPassword!!.text
        write("email", Email.toJson(Email.instance))
        val frame = Frame(PathToView.ListOfEmail.path)
        frame.isResizable = false
        frame.show()
        closeStage(textFieldEmail!!)
    }
}