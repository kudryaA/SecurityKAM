package kam

import kam.mail.Sender
import kam.struct.Email
import kam.struct.ListEmail

fun sendNotification() {
    Thread({
        while(true) {
            ListEmail.instance.forEach {
                val sender = Sender(Email.instance, it)
            }
            Thread.sleep(600000)
        }
    }).start()
}