package kam.picture

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun writeImage(img: BufferedImage?, path: String) {
    ImageIO.write(img, "PNG", File(path))
}