package kam

import com.google.gson.JsonIOException
import javafx.application.Application
import javafx.application.Application.launch
import javafx.stage.Stage
import kam.design.PathToView
import kam.design.component.Frame
import kam.struct.Email
import kam.struct.ListEmail
import java.io.File

fun main(args: Array<String>) {
    launch(Main::class.java)
}

class Main: Application() {
    override fun start(primaryStage: Stage?) {
        if (!File("email").exists()) {
            openSettings()
        }
        else {
            try {
                Email.instance = Email.fromJson(read("email"))
                if (!File("list").exists()) {
                    openList()
                } else {
                    val text = read("list")
                    text.split("\n").forEach {
                        ListEmail.instance.add(it)
                    }
                    if (!File("password").exists()) {
                        openPassword()
                    } else {
                        val text = read("password")
                        password = text.replace("\n", "")
                        val frame = Frame(PathToView.PasswordEnter.path)
                        frame.isResizable = false
                        frame.setOnCloseRequest {
                            sendNotification()
                        }
                        frame.show()
                    }
                }
            } catch (e: JsonIOException) {
                e.printStackTrace()
                openSettings()
            }
        }


    }

    private fun openSettings() {
        val frame = Frame(PathToView.SettingUser.path)
        frame.isResizable = false
        frame.show()
    }

    private fun openList() {
        val frame = Frame(PathToView.ListOfEmail.path)
        frame.isResizable = false
        frame.show()
    }

    private fun openPassword() {
        val frame = Frame(PathToView.SetPassword.path)
        frame.isResizable = false
        frame.show()
    }

}