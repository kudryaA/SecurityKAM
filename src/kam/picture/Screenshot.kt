package kam.picture

import java.awt.AWTException
import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage

class Screenshot : Picture {
    override fun getImage(): BufferedImage? {
        try {
            return Robot().createScreenCapture(Rectangle(Toolkit.getDefaultToolkit().screenSize))
        } catch (e: SecurityException) {
        } catch (e: AWTException) {
        }

        return null
    }
}