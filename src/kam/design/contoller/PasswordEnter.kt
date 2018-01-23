package kam.design.contoller

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.PasswordField
import kam.design.closeStage
import kam.getHash
import kam.read
import kam.sendNotification
import java.net.URL
import java.util.*

class PasswordEnter: Initializable {

    @FXML
    private var textFieldPassword: PasswordField? = null

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        Thread({
            Thread.sleep(60000)
            sendNotification()
        }).start()
    }

    @FXML
    private fun clickOk() {
        val passwordCorrect = read("password")
        val password = getHash(textFieldPassword!!.text)

        if (password == passwordCorrect) {
            System.exit(0)
        } else {
            sendNotification()
            closeStage(textFieldPassword!!)
        }
    }

}