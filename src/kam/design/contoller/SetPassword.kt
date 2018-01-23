package kam.design.contoller

import javafx.fxml.FXML
import javafx.scene.control.PasswordField
import kam.design.closeStage
import kam.design.showDialog
import kam.getHash
import kam.write

class SetPassword {
    @FXML
    private var textFieldPassword: PasswordField? = null
    @FXML
    private var textFieldConfirm: PasswordField? = null

    @FXML
    private fun clickOk() {
        val password = textFieldPassword!!.text
        val confirm = textFieldConfirm!!.text

        if (password == confirm) {
            write("password", getHash(textFieldPassword!!.text))
            closeStage(textFieldPassword!!)
            showDialog("The program is configured. It starts with the next program start.")
        }

    }
}