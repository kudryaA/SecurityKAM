package kam.picture

import java.awt.image.BufferedImage
import com.github.sarxos.webcam.Webcam



class Selfi: Picture {
    override fun getImage(): BufferedImage? {
        val webcam = Webcam.getDefault()
        webcam.open()
        val image = webcam.image
        webcam.close()
        return image
    }
}